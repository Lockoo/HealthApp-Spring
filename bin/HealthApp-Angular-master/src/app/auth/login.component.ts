import {Component} from '@angular/core';
import {Login, LoginStatus} from './login';
import {UsersInfo} from './UsersInfo';
import {AuthService} from './auth.service';
//import {LoginService} from './login.service';
import {Router} from '@angular/router';

@Component({
  selector: 'Login',
  templateUrl: './login.component.html'
})
export class LoginComponent
{

  alertStyle = '';
  model = new Login('', '');
  loginStatus = new LoginStatus('', '', null);

  constructor(private authService: AuthService, private router: Router) {}


  onLogin()
  {
    this.reset();
    this.authService.login(this.model)
      .subscribe((status: LoginStatus) =>
      {
        this.loginStatus = status;
        if (this.loginStatus.code === 'FAILURE')
        {
          this.alertStyle = 'alert alert-danger';
        }
        else
        {
          //Navigate to user Component(Todo)
          //this.router.navigate(['/auth/user']);
        }
      });
  }

  onLogout()
  {
    this.authService.logout();
  }

  private reset()
  {
    this.alertStyle = '';
    this.loginStatus.code = '';
    this.loginStatus.message = '';
  }

  //warum erst bei 2. aufrum daten da?
  public getUserCount()
  {

    //    this.client.get<UsersInfo>('http://localhost:8080/login/count')
    //      .subscribe(data => {
    //        alert('count: ' + data.count + ', message: ' + data.message);
    //      });

    //    alert('service invoked');
    //    this.loginService.getUserCount()
    //      .subscribe(usersInfo => this.usersInfo = usersInfo,
    //      error => this.errorMessage = <any>error);
    //    alert(this.usersInfo.count);
    //    alert(this.usersInfo.message);
  }

}
