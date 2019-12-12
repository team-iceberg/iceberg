import {CommonModule} from '@angular/common';
import {NgModule} from '@angular/core';
import {AssociationService} from '../services/association/association.service';
import {HomeComponent} from './component/home.component';
import {HomeRoutingModule} from './home-routing.module';

@NgModule({
    declarations: [
        HomeComponent
    ],
    imports: [
        HomeRoutingModule,
        CommonModule
    ],
    providers: [
        AssociationService
    ],
    bootstrap: [HomeComponent]
})

export class HomeModule {
}
