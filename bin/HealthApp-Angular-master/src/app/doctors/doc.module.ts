import { NgModule }       from '@angular/core';
import { FormsModule }    from '@angular/forms';
import { HttpModule } from '@angular/http';
import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';

import { DocHomeComponent } from './doc-home.component';
import { DoctorListComponent } from './doctor-list.component';
import { DoctorService } from './doctor.service';
import { DocRoutingModule } from './doctors-app-routing-module';

@NgModule({
  imports: [
    CommonModule, FormsModule, HttpModule, HttpClientModule, DocRoutingModule
  ],
  declarations: [
     DocHomeComponent, DoctorListComponent
  ],
  providers: [DoctorService]
})
export class DocModule {}
