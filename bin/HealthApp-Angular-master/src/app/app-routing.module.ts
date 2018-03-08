import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {AppComponent} from './app.component';
import {LoginComponent} from './auth/login.component';
import {HomeComponent} from './home.component';




const appRoutes: Routes = [
  {path: 'index', component: HomeComponent},
  {path: '', redirectTo: 'index', pathMatch: 'full'},
  {path: 'login', component: LoginComponent},
];

@NgModule({
  imports: [
    RouterModule.forRoot(appRoutes)
  ],
  exports: [
    RouterModule
  ]
})
export class AppRoutingModule
{

}
