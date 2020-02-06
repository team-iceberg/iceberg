import {Component} from '@angular/core';
import {MatTableDataSource} from '@angular/material';
import {Association} from '../../models/association';
import {AssociationService} from '../../services/association/association.service';
import {Color} from '../../models/color';
import {ColorService} from '../../services/color/color.service';
import {Size} from '../../models/size';
import {SizeService} from '../../services/size/size.service';
import {Family} from '../../models/family';
import {FamilyService} from '../../services/family/family.service';

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

    columnsDefinitionSize: string[] = ['libelle'];
    dataSourceSize: MatTableDataSource<Size> = new MatTableDataSource<Size>();

    columnsDefinitionFamily: string[] = ['libelle'];
    dataSourceFamily: MatTableDataSource<Family> = new MatTableDataSource<Family>();

    constructor(private associationService: AssociationService, private colorService: ColorService, private sizeService: SizeService, private familyService: FamilyService) {
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

    getSizes() {
        this.sizeService.getAll().subscribe(data => {
            this.dataSourceSize.data = data;
        });
    }

    getFamilies() {
        this.familyService.getAll().subscribe(data => {
            this.dataSourceFamily.data = data;
        });
    }
}
