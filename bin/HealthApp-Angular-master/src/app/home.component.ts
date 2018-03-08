import {Component, Pipe, PipeTransform, SecurityContext} from '@angular/core';
import {DomSanitizer, SafeHtml} from '@angular/platform-browser';


@Component({
  template: `
    <div class="jumbotron">
      <h1>Welcome to HealthApp </h1>
      <p>This is a platform bringing together Doctors and Patients and helping them communicate, collaborate.</p>
    </div>
        <div class="col-sm-offset-2 col-sm-10" style="padding-top: 20px">
      <span style="padding-right: 5px"><a routerLink="/auth/register" routerLinkActive="active">New User? Sign up</a></span>
      <span style="padding-right: 5px"><a routerLink="/auth/login" routerLinkActivate="active">Login to existing Account</a></span>
      <span style="padding-left: 5px"><a href="/auth/forgotpassword" routerLinkActive="active">Forgot Password?</a></span>
    </div>
    <p></p>
    <div>
      <span style="padding-right: 5px"><a href="/doc/list" routerLinkActive="active">List all Doctors</a></span>
    </div>
  `
})
export class HomeComponent
{
}


