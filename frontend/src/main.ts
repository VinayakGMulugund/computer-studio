import { bootstrapApplication } from "@angular/platform-browser";
import { AppComponent } from "./app/app.component";
import { AppConfig } from "./app/app.config";
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { importProvidersFrom } from "@angular/core";
import {routes} from './app/app.routes';
import { provideRouter } from "@angular/router";


bootstrapApplication(AppComponent, {
    providers: [
        provideRouter(routes),
        importProvidersFrom(BrowserAnimationsModule),
    ]
})
.catch(e => console.log(e));