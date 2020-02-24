import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {ColorComponent} from "./component/color.component";

export const routes: Routes = [
    {
        path: '',
        component: ColorComponent
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
export class ColorRoutingModule {
}
