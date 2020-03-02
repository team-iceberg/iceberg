import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {SizeComponent} from './component/size.component';

export const routes: Routes = [
    {
        path: '',
        component: SizeComponent
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
export class SizeRoutingModule {
}
