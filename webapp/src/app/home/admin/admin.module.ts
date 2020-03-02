import {CommonModule} from '@angular/common';
import {NgModule} from '@angular/core';
import {FlexModule, FlexLayoutModule} from '@angular/flex-layout';
import {RouterModule} from '@angular/router';
import {TranslateModule} from '@ngx-translate/core';
import {MaterialModule} from '../../shared/material/material.module';
import {SharedModule} from '../../shared/shared.module';
import {AdminRoutingModule} from './admin-routing.module';
import {AdminComponent} from './component/admin.component';

@NgModule({
    declarations: [
        AdminComponent
    ],
    imports: [
        AdminRoutingModule,
        SharedModule,
        TranslateModule,
        FlexModule,
        RouterModule,
        MaterialModule,
        CommonModule,
        FlexLayoutModule
    ],
    bootstrap: [AdminComponent]
})

export class AdminModule {
}
