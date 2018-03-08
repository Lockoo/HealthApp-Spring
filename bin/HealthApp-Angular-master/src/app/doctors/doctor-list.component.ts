import {Component, OnInit, DoCheck, Input, IterableDiffers} from '@angular/core';
import {Router, ActivatedRoute, ParamMap} from '@angular/router';
import 'rxjs/add/operator/switchMap';

import {Doctor} from './doctor';
import {DoctorService} from './doctor.service';

@Component({
  selector: 'doctor-list',
  templateUrl: './doctor-list.component.html'
})
export class DoctorListComponent
{
  doctors: Doctor[];
  selectedDoctor: Doctor;
  firstName: string;
  errorMessage: string;
  setSpeciality: string;
  error = '';


  constructor(private doctorService: DoctorService)
  {
    this.doctors = new Array();
    this.selectedDoctor = new Doctor(-1, '', '', '', '');
  }

  showAll()
  {
    this.setSpeciality = 'All';
    this.doctorService.getAllDoctors()
      .subscribe(doctors => this.doctors = doctors,
      error =>
      {
        this.error = error;
        alert(error);
        console.error('An error occurred in retrieving doctors list, navigating to login: ', error);
      });
  }

  showDoctors()
  {
    this.doctorService.getDoctorsBySpeciality(this.setSpeciality)
      .subscribe(doctors => this.doctors = doctors,
      error => this.error = error);
  }

  onSelect(speciality: string)
  {
    this.setSpeciality = speciality;
    this.showDoctors();
  }

  onChangeFirstName()
  {
    let index;
    for (let i = 0; i < this.doctors.length; i++)
    {
      if (this.doctors[i].id === this.selectedDoctor.id)
      {
        index = i;
      }
    }
    this.doctorService.changeFirstName(this.selectedDoctor, this.firstName)
      .subscribe(doctor => this.doctors[index] = doctor);
  }

  deleteDoctor(doctor: Doctor)
  {
    this.doctorService.deleteDoctor(doctor).subscribe();
    let index = this.doctors.findIndex(doc => doc.email === doctor.email);
    this.doctors.splice(index, 1);
  }



}
