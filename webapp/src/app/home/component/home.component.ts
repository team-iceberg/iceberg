import {Component} from '@angular/core';
import {MatTableDataSource} from '@angular/material';
import {Association} from '../../models/association';
import {AssociationService} from '../../services/association/association.service';
import {Coloris} from '../../models/coloris';
import {ColorisService} from '../../services/coloris/coloris.service';

@Component({
    selector: 'home',
    templateUrl: './home.component.html',
    styleUrls: ['./home.component.less']
})
export class HomeComponent {
    columnsDefinition: string[] = ['name', 'mail', 'president'];
    dataSource: MatTableDataSource<Association> = new MatTableDataSource<Association>();

    columnsDefinitionColoris: string[] = ['libelle', 'codeHexa'];
    dataSourceColoris: MatTableDataSource<Coloris> = new MatTableDataSource<Coloris>();

    constructor(private associationService: AssociationService, private colorisService: ColorisService) {
    }

    getAssociations() {
        this.associationService.getAll().subscribe(data => {
            this.dataSource.data = data;
        });
    }

    getColoris() {
        this.colorisService.getAll().subscribe(data => {
            this.dataSourceColoris.data = data;
        });
    }
}
