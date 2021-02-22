import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';
import {AddInfoComponent} from '../add-info/add-info.component';
import {AuListComponent} from '../au-list/au-list.component';

const appRouts : Routes = [
  {
    path:'add',
    component: AddInfoComponent
  },
  {
    path:'list',
    component: AuListComponent
  },
  {
    path:'**',redirectTo:'root'
    }
]

@NgModule({
  declarations: [],
  imports: [
    RouterModule.forRoot(appRouts),
    CommonModule
  ],
  exports:[RouterModule]
})
export class AppRoutingModule { }
