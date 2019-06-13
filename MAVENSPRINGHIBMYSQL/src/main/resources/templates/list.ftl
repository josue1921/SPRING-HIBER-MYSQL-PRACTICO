<div class="generic-container">
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">REGISTRO DE USUARIOS </span></div>
        <div class="panel-body">
            <div class="formcontainer">
                <div class="alert alert-success" role="alert" ng-if="ctrl.successMessage">{{ctrl.successMessage}}</div>
                <div class="alert alert-danger" role="alert" ng-if="ctrl.errorMessage">{{ctrl.errorMessage}}</div>
                <form ng-submit="ctrl.submit()" name="myForm" class="form-horizontal">
                    <input type="hidden" ng-model="ctrl.user.id" />
                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-lable" for="uname">Name</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.user.name" id="uname" class="username form-control input-sm" placeholder="Ingresa tu nombre(s)" required />
                            </div>
                        </div>
                    </div>
 					
 					<div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-lable" for="uname">Apellido Paterno</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.user.apat" id="apat" class="username form-control input-sm" placeholder="Ingresa tu apellido paterno" required/>
                            </div>
                        </div>
                    </div>
 					
 					<div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-lable" for="uname">Apellido Materno</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.user.amat" id="apat" class="username form-control input-sm" placeholder="Ingresa tu apellido materno" required />
                            </div>
                        </div>
                    </div>
 					
                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-lable" for="age">Edad</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.user.age" id="age" class="form-control input-sm" placeholder="Ingresa tu edad." required ng-pattern="ctrl.onlyIntegers"/>
                            </div>
                        </div>
                    </div>
     
     				<div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-lable" for="email">Email</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.user.email" id="age" class="form-control input-sm" placeholder="Ingresa tu email." required />
                            </div>
                        </div>
                    </div>
     				
                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-lable" for="phone">Telefono</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.user.phone" id="phone" class="form-control input-sm" placeholder="Ingresa tu numero de telefono." required ng-pattern="ctrl.onlyNumbers"/>
                            </div>
                        </div>
                    </div>
 
 					<div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-lable" for="rfc">RFC</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.user.rfc" id="rfc" class="form-control input-sm" placeholder="Ingresa RFC" required/>
                            </div>
                        </div>
                    </div>
 
 					<div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-lable" for="estatus">Estatus</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.user.estatus" id="estatus" class="form-control input-sm" placeholder="Selecciona un estatus" required />
                            </div>
                        </div>
                    </div>
 					
                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-lable" for="ies">IS</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.user.ies" id="ies" class="form-control input-sm" placeholder="Ingresa un IS." required ng-minlength="4"/>
                            </div>
                        </div>
                    </div>
     
                    <div class="row">
                        <div class="form-actions floatRight">
                            <input type="submit"  value="{{!ctrl.user.id ? 'Add' : 'Update'}}" class="btn btn-primary btn-sm" ng-disabled="myForm.$invalid || myForm.$pristine">
                            <button type="button" ng-click="ctrl.reset()" class="btn btn-warning btn-sm" ng-disabled="myForm.$pristine">Reset Form</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>    
    </div>
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">Lista de usuarios </span></div>
        <div class="panel-body">
            <div class="table-responsive">
                <table class="table table-hover">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>NOMBRE</th>
                        <th>APELLIDO PATERNO</th>
                        <th>APELLIDO MATERNO</th>
                        <th>EDAD</th>
                        <th>EMAIL</th>
                        <th>TELEFONO</th>
                        <th>RFC</th>
                        <th>ESTATUS</th>
                        <th>IS</th>
                        <th width="100"></th>
                        <th width="100"></th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr ng-repeat="u in ctrl.getAllUsers()">
                        <td>{{u.id}}</td>
                        <td>{{u.name}}</td>
                        <td>{{u.apat}}</td>
                        <td>{{u.amat}}</td>
                        <td>{{u.age}}</td>
                        <td>{{u.email}}</td>
                        <td>{{u.phone}}</td>
                        <td>{{u.rfc}}</td>
                        <td>{{u.estatus}}</td>
                        <td>{{u.ies}}</td>
                        <td><button type="button" ng-click="ctrl.editUser(u.id)" class="btn btn-success custom-width">Edit</button></td>
                        <td><button type="button" ng-click="ctrl.removeUser(u.id)" class="btn btn-danger custom-width">Remove</button></td>
                    </tr>
                    </tbody>
                </table>      
            </div>
        </div>
    </div>
</div>