
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LibComponent } from './library/library.component';

const routes: Routes = [
  { path:'', component: LibComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }