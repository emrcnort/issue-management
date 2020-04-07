import { NgModule } from '@angular/core';
import { RouterModule,Routes } from '@angular/router';




const routes: Routes = [

  {
    path: '', pathMatch: 'full', redirectTo: 'dashboard'},
  {path: 'dashboard',  loadChildren : () => import('./pages/dashboard/dashboard.module').then(m => m.DashboardModule)},
  {path: 'issue', loadChildren : () => import('./pages/issue/issue.module').then(m => m.IssueModule)},
  {path: 'project', loadChildren : () => import('./pages/project/project.module').then(m => m.ProjectModule)}

];



@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
