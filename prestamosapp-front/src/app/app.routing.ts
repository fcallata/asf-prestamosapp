import { ModuleWithProviders } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AuthGuard } from './guards/auth.guard'

import { PrestamosComponent } from './pages/prestamos/prestamos.component';
import { LoginComponent} from './pages/login/login.component';


const appRoutes:Routes = [
    { path:'', component: PrestamosComponent, canActivate:[AuthGuard] },
	{ path:'home', component: PrestamosComponent, canActivate:[AuthGuard] },
	{ path:'login', component: LoginComponent, },	
	{ path: '**', component: PrestamosComponent, canActivate:[AuthGuard] }
];

export const appRoutingProviders: any [] = [];
export const routing: ModuleWithProviders = RouterModule.forRoot(appRoutes);