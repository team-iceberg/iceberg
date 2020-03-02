import {CommonModule} from '@angular/common';
import {NgModule} from '@angular/core';
import {FlexLayoutModule, FlexModule} from '@angular/flex-layout';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {RouterModule} from '@angular/router';
import {TranslateModule} from '@ngx-translate/core';
import {MaterialModule} from '../../../shared/material/material.module';
import {AssociationRoutingModule} from '../association/association-routing.module';
import {ColorComponent} from "./component/color.component";
import {ColorRoutingModule} from "./color-routing.module";

@NgModule({
    declarations: [
        ColorComponent
    ],
    imports: [
        ColorRoutingModule,
        TranslateModule,
        MaterialModule
    ],
    bootstrap: [ColorComponent]
})

export class ColorModule {
}
