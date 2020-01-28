import {Component} from '@angular/core';
import {MatTableDataSource} from '@angular/material';
import {Association} from '../../models/association';
import {AssociationService} from '../../services/association/association.service';
import {Color} from '../../models/color';
import {ColorService} from '../../services/color/color.service';

@Component({
    selector: 'home',
    templateUrl: './home.component.html',
    styleUrls: ['./home.component.less']
})
export class HomeComponent {
    columnsDefinition: string[] = ['name', 'mail', 'president'];
    dataSource: MatTableDataSource<Association> = new MatTableDataSource<Association>();

    columnsDefinitionColor: string[] = ['libelle', 'codeHexa'];
    dataSourceColor: MatTableDataSource<Color> = new MatTableDataSource<Color>();

    constructor(private associationService: AssociationService, private colorService: ColorService) {
    }

    getAssociations() {
        this.associationService.getAll().subscribe(data => {
            this.dataSource.data = data;
        });
    }

    getColors() {
        this.colorService.getAll().subscribe(data => {
            this.dataSourceColor.data = data;
        });
    }
}
