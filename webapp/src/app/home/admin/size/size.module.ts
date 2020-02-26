import {CommonModule} from '@angular/common';
import {NgModule} from '@angular/core';
import {FlexLayoutModule, FlexModule} from '@angular/flex-layout';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {RouterModule} from '@angular/router';
import {TranslateModule} from '@ngx-translate/core';
import {MaterialModule} from '../../../shared/material/material.module';
import {SizeComponent} from './component/size.component';
import {SizeRoutingModule} from './size-routing.module';

@NgModule({
    declarations: [
        SizeComponent
    ],
    imports: [
        SizeRoutingModule,
        TranslateModule,
        FlexModule,
        FlexLayoutModule,
        RouterModule,
        MaterialModule,
        CommonModule,
        FormsModule,
        ReactiveFormsModule
    ],
    bootstrap: [SizeComponent]
})

export class SizeModule {
}
