import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';

import {DocHomeComponent} from './doc-home.component';
import { DoctorListComponent } from './doctor-list.component';

const authRoutes: Routes = [
  {
    path: 'doc', component: DocHomeComponent,
    children: [
      {
        path: 'list',
        component: DoctorListComponent,
      },
      {
        path: 'speciality',
        component: DoctorListComponent
      },
      {
        path: ':speciality',
        component: DoctorListComponent
      }
    ]
  }
];

@NgModule({
  imports: [
    RouterModule.forChild(authRoutes)
  ],
  exports: [
    RouterModule
  ]
})
export class DocRoutingModule {}
