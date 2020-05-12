import {NgModule} from '@angular/core';
import {FlexModule, FlexLayoutModule} from '@angular/flex-layout';
import {
    MatButtonModule,
    MatDividerModule,
    MatFormFieldModule,
    MatIconModule,
    MatInputModule,
    MatListModule,
    MatProgressSpinnerModule,
    MatSnackBarModule,
    MatTableModule,
    MatToolbarModule
} from '@angular/material';

@NgModule({
    imports: [
        MatFormFieldModule,
        MatInputModule,
        MatButtonModule,
        MatTableModule,
        MatIconModule,
        MatListModule,
        MatDividerModule,
        MatProgressSpinnerModule,
        MatToolbarModule,
        MatSnackBarModule,
        FlexModule,
        FlexLayoutModule
    ],
    exports: [
        MatFormFieldModule,
        MatInputModule,
        MatButtonModule,
        MatTableModule,
        MatIconModule,
        MatListModule,
        MatDividerModule,
        MatProgressSpinnerModule,
        MatToolbarModule,
        MatSnackBarModule,
        FlexModule,
        FlexLayoutModule
    ]
})
export class MaterialModule {
}
