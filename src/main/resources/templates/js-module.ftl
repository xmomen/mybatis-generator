'use strict';

<#include "header.ftl">
define([
    "angularAMD",
    "${targetWebModule}/${domainObjectName}_api",
    "${targetWebModule}/${domainObjectName}"
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
                        //controllerUrl: "${targetWebModule}/${domainObjectName}.js",
                        templateUrl: '${targetWebModule}/${domainObjectName}.html'
                    })
                }
            });

            angular.forEach(states, function(state){
                $stateProvider.state(state.name, angularAMD.route(state));
            });
        }
    ]);
});