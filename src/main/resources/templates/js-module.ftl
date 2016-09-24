'use strict';

<#include "header.ftl">
define([
    "angularAMD",
    "${moduleName}/${domainObjectName}_api",
    "${moduleName}/${domainObjectName}"
],function(angularAMD, ${domainObjectClassName}Rest, ${domainObjectName}){
    angular.module('${domainObjectName}.module',[
        "${domainObjectClassName}.REST"
    ]).config(['$stateProvider', '$urlRouterProvider',
        function ($stateProvider,   $urlRouterProvider) {

            var states = [];

            states.push({
                title: "${tableComment}",
                name: 'app.${domainObjectName}',
                url: '/${moduleName}/${domainObjectName}',
                views: {
                    '${domainObjectName}': angularAMD.route({
                        controller: ${domainObjectName},
                        //controllerUrl: "${moduleName}/${domainObjectName}.js",
                        templateUrl: '${moduleName}/${domainObjectName}.html'
                    })
                }
            });

            angular.forEach(states, function(state){
                $stateProvider.state(state.name, angularAMD.route(state));
            });
        }
    ]);
});