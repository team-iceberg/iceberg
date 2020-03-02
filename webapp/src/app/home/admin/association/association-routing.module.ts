import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {AssociationComponent} from './component/association.component';

export const routes: Routes = [
    {
        path: '',
        component: AssociationComponent
    },
    {
        path: '**',
        redirectTo: ''
    }
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class AssociationRoutingModule {
}
