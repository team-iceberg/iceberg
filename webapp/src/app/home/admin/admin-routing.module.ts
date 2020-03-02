import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {AdminComponent} from './component/admin.component';

export const routes: Routes = [
    {
        path: '',
        component: AdminComponent,
        children: [
            {
                path: 'association',
                loadChildren: './association/association.module#AssociationModule'
            },
            {
                path: 'color',
                loadChildren: './color/color.module#ColorModule'
            },
            {
                path: 'size',
                loadChildren: './size/size.module#SizeModule'
            }
        ]
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
export class AdminRoutingModule {
}
