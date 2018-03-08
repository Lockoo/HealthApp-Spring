import {Doctor, UpdatedDoc} from './doctor';
import {HttpHeaders} from '@angular/common/http';
import {HttpClient} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';



//import {Cookie} from 'ng2-cookies';

@Injectable()
export class DoctorService
{
  private doctorsUrl = 'http://localhost:8080/doc/';
  public doctors: Observable<Doctor[]>;
  private httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  };

  constructor(private http: HttpClient)
  {
  }

  getDoctorsBySpeciality(speciality: string): Observable<Doctor[]>
  {
    const url = this.doctorsUrl + 'bySpeciality';
    return this.http.post<Doctor[]>(url, speciality, this.httpOptions);
  }

  getAllDoctors(): Observable<Doctor[]>
  {
    return this.http.get<Doctor[]>(this.doctorsUrl);
  }

  changeFirstName(doc: Doctor, firstName: string): Observable<Doctor>
  {
    const url = this.doctorsUrl + 'changeFirstName';
    const updatedDoc = new UpdatedDoc(doc, firstName);
    return this.http.post<Doctor>(url, updatedDoc, this.httpOptions);
  }

  deleteDoctor(doctor: Doctor)
  {
    const url = this.doctorsUrl + 'delete';
    return this.http.post(url, doctor, this.httpOptions);
  }

}



