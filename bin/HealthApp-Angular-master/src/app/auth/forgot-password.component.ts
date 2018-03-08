import { Component } from '@angular/core';

import { Login } from './login';

@Component({
  templateUrl: './forgot-password.component.html'
})
export class ForgotPasswordComponent {

  model = new Login('', '');

  onSubmit() {
    alert('To be implemented');
  }
}
