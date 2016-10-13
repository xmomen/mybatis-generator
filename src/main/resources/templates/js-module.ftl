'use strict';

<#include "header.ftl">
define([
    "angularAMD",
    "./${domainObjectName}_api",
    "./${domainObjectName}"
],function(angularAMD, ${domainObjectClassName}Rest, ${domainObjectName}){
    angular.module('${domainObjectName}.module',[
        "${domainObjectClassName}.REST"
    ]).config(['$stateProvider', '$urlRouterProvider',
        function ($stateProvider,   $urlRouterProvider) {

            var states = [];

            states.push({
                title: "${tableComment}",
                name: 'app.${domainObjectName}',
                url: '/${restMapping}',
                views: {
                    '${domainObjectName}': angularAMD.route({
                        controller: ${domainObjectName},
                        //controllerUrl: "${moduleName}/${domainObjectName}.js",
                        templateUrl: 'modules/${moduleName}/${domainObjectName}.html'
                    })
                },
                sticky: true
            });

            angular.forEach(states, function(state){
                $stateProvider.state(state.name, angularAMD.route(state));
            });
        }
    ]);
});