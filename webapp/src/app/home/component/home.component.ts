import {Component} from '@angular/core';
import {AssociationService} from '../../services/association/association.service';

@Component({
    selector: 'home',
    templateUrl: './home.component.html',
    styleUrls: ['./home.component.less']
})
export class HomeComponent {

    constructor(private associationService: AssociationService) {
    }

    getAssociations() {
        this.associationService.getAll().subscribe(data => console.log(data));
    }
}
