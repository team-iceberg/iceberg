import {CommonModule} from '@angular/common';
import {NgModule} from '@angular/core';
import {FlexLayoutModule, FlexModule} from '@angular/flex-layout';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {RouterModule} from '@angular/router';
import {TranslateModule} from '@ngx-translate/core';
import {MaterialModule} from '../../../shared/material/material.module';
import {AssociationRoutingModule} from './association-routing.module';
import {AssociationComponent} from './component/association.component';

@NgModule({
    declarations: [
        AssociationComponent
    ],
    imports: [
        AssociationRoutingModule,
        TranslateModule,
        MaterialModule
    ],
    bootstrap: [AssociationComponent]
})

export class AssociationModule {
}
