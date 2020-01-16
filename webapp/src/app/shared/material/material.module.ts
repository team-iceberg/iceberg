import {NgModule} from '@angular/core';
import {
    MatButtonModule,
    MatDividerModule,
    MatFormFieldModule,
    MatIconModule,
    MatInputModule,
    MatListModule,
    MatTableModule,
    MatProgressSpinnerModule
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
        MatProgressSpinnerModule
    ],
    exports: [
        MatFormFieldModule,
        MatInputModule,
        MatButtonModule,
        MatTableModule,
        MatIconModule,
        MatListModule,
        MatDividerModule,
        MatProgressSpinnerModule
    ]
})
export class MaterialModule {
}
