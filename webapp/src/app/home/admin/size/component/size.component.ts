import {Component} from '@angular/core';
import {MatTableDataSource} from '@angular/material';
import {Router} from '@angular/router';
import {Size} from '../../../../models/size';
import {User} from '../../../../models/user';
import {ColorService} from "../../../../services/color/color.service";
import {Color} from "../../../../models/color";
import {SizeService} from '../../../../services/size/size.service';

@Component({
  selector: 'size',
  templateUrl: './size.component.html',
  styleUrls: ['./size.component.less']
})
export class SizeComponent {
  user: User;

  columnsDefinition: string[] = ['id', 'libelle'];
  dataSource: MatTableDataSource<Size> = new MatTableDataSource<Size>();

  constructor(private sizeService: SizeService) {
  }

  getSizes() {
    this.sizeService.getAll().subscribe(data => {
      this.dataSource.data = data;
    });
  }
}
