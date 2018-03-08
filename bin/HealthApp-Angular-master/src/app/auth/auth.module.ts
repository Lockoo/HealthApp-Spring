import {NgModule} from '@angular/core';
import {FormsModule} from '@angular/forms';
import {LoginComponent} from './login.component';
import {AuthService} from './auth.service';
import {CommonModule} from '@angular/common';


import {AuthRoutingModule} from './auth-app-routing.module';
import { AuthComponent } from './auth.component';
import { DoctorRegistrationComponent } from './doc-registration.component';
import { ForgotPasswordComponent } from './forgot-password.component';
import { LogoutComponent } from './logout.component';
import { UserRegistrationComponent } from './user-registration.component';


@NgModule({
  imports: [CommonModule, FormsModule, AuthRoutingModule],
  declarations: [AuthComponent, LoginComponent,
  UserRegistrationComponent, ForgotPasswordComponent, LogoutComponent, DoctorRegistrationComponent],
  providers: [{provide: AuthService, useClass: AuthService}
  ]
})
export class AuthModule {}

