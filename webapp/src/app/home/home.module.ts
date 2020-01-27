import {CommonModule} from '@angular/common';
import {NgModule} from '@angular/core';
import {TranslateModule} from '@ngx-translate/core';
import {AssociationService} from '../services/association/association.service';
import {ColorisService} from '../services/coloris/coloris.service';
import {MaterialModule} from '../tools/material/material.module';
import {HomeComponent} from './component/home.component';
import {HomeRoutingModule} from './home-routing.module';

@NgModule({
    declarations: [
        HomeComponent
    ],
    imports: [
        HomeRoutingModule,
        CommonModule,
        MaterialModule,
        TranslateModule
    ],
    providers: [
        AssociationService,
        ColorisService
    ],
    bootstrap: [HomeComponent]
})

export class HomeModule {
}
