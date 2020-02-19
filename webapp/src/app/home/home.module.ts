import {CommonModule} from '@angular/common';
import {NgModule} from '@angular/core';
import {TranslateModule} from '@ngx-translate/core';
import {AssociationService} from '../services/association/association.service';
import {ColorService} from '../services/color/color.service';
import {SizeService} from '../services/size/size.service';
import {HomeComponent} from './component/home.component';
import {HeaderComponent} from './header/header.component';
import {HomeRoutingModule} from './home-routing.module';
import {MaterialModule} from "../shared/material/material.module";

@NgModule({
    declarations: [
        HomeComponent,
        HeaderComponent
    ],
    imports: [
        HomeRoutingModule,
        CommonModule,
        MaterialModule,
        TranslateModule
    ],
    providers: [
        AssociationService,
        ColorService,
        SizeService
    ],
    bootstrap: [HomeComponent]
})

export class HomeModule {
}
