import {Login, SignupStatus, NewUser} from './login';
import {Injectable} from '@angular/core';
import {Http, RequestOptions, Response, Headers} from '@angular/http';

import {Observable} from 'rxjs/Observable';
import 'rxjs/add/observable/of';
import 'rxjs/add/operator/do';
import 'rxjs/add/operator/delay';

//import {Login, LoginStatus, NewUser, SignupStatus} from './login';
import {Observer} from 'rxjs/Observer';
import {Router} from '@angular/router';
//import {Cookie} from 'ng2-cookies';

@Injectable()
export class AuthService
{

  public isLoggedIn: Observable<boolean>;
  public user = {name: 'Guest'};
  public redirectUrl: string;

  private observer: Observer<boolean>;
  private serverUrl = 'http://localhost:8080';
  private headers = new Headers({'Content-Type': 'application/json'});

  constructor(private http: Http, private router: Router)
  {
    this.isLoggedIn = new Observable(observer => this.observer = observer);
  }

  private checkLoginStatus(): Observable<boolean>
  {
    return this.isLoggedIn;
  }


  //TODO MAPPING
  public signup(newUser: NewUser): Promise<SignupStatus>
  {
    const url = `${this.serverUrl}/account/signup`;
    const options = new RequestOptions({headers: this.headers});

    return this.http.post(url, newUser, options)
      .toPromise()
      .then(res => res.json())
      .catch((error: any) => Observable.throw(error.json().error || 'Server error'));
  }

  public login(login: Login): Observable<SignupStatus>
  {
    const url = `${this.serverUrl}/account/login`;

    return this.http.post(url, login, {headers: this.headers})
      .map(response =>
      {
        const body = response.json();
        if (body.code === 'USER_LOGIN_SUCCESSFUL')
        {
          this.changeLoginStatus(true);
        }
        return response.json();
      })
      .catch((error: any) => Observable.throw(error.json().error ||
        'Server error'));
  }

  public logout(): void
  {
    this.changeLoginStatus(true);
  }

  public changeLoginStatus(status: boolean)
  {
    if (this.observer !== undefined)
    {
      this.observer.next(status);
    }
  }
}
