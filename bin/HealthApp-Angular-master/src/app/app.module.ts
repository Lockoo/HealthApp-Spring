import {NgModule} from '@angular/core';
import {FormsModule} from '@angular/forms';

import {AppComponent} from './app.component';
import {AppRoutingModule} from './app-routing.module';
import { AuthComponent } from './auth/auth.component';


import {AuthModule } from './auth/auth.module';
import { HomeComponent } from './home.component';
import { PageNotFoundComponent } from './page-not-found.component';
import {HttpClientModule} from '@angular/common/http';
import {HttpModule} from '@angular/http';
import {RouterModule} from '@angular/router';
import {BrowserModule} from '@angular/platform-browser';
import {provideRoutes} from '@angular/router';


import {DocModule} from './doctors/doc.module';



@NgModule({
  declarations: [
    AppComponent,
    PageNotFoundComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    HttpClientModule,
    AppRoutingModule,
    RouterModule,
    AuthModule,
    DocModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {}


