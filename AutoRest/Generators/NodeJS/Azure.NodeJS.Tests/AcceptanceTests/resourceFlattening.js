﻿// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License. See License.txt in the project root for license information.

'use strict';

var should = require('should');
var http = require('http');
var util = require('util');
var assert = require('assert');
var msRestAzure = require('ms-rest-azure');
var msRest = require('ms-rest');

var flatteningClient = require('../Expected/SwaggerBat/ResourceFlattening/AutoRestResourceFlatteningTestService');

var dummySubscriptionId = 'a878ae02-6106-429z-9397-58091ee45g98';
var dummyToken = 'dummy12321343423';
var credentials = new msRestAzure.SubscriptionCredentials(dummyToken, dummySubscriptionId);

var clientOptions = {};
var baseUri = 'http://localhost:3000';

describe('nodejs', function () {
  
  describe('Swagger ResourceFlattening BAT', function () {
    
    describe('Resource Flattening Operations', function () {
      var testOptions = clientOptions;
      testOptions.requestOptions = { jar: true };
      testOptions.filters = [new msRest.ExponentialRetryPolicyFilter(3, 0, 0, 0)];
      testOptions.noRetryPolicy = true;
      var testClient = new flatteningClient(credentials, baseUri, clientOptions);
      
      it('should get external resource as an array', function (done) {
        var expectedResult = [
          {
            id: '1',
            location: 'Building 44',
            name: 'Resource1',
            provisioningState: 'Succeeded',
            properties: {
              provisioningStateValues: 'OK',
              pname: 'Product1'
              ,
              tags: { tag1: 'value1', tag2: 'value3' },
              type: 'Microsoft.Web/sites'
            }
          }, 
          {
            id: '2', 
            name: 'Resource2', 
            location: 'Building 44'
          }, 
          {
            id: '3',
            name: 'Resource3'
          }
        ];
        testClient.getArray(function (error, result) {
          should.not.exist(error);
          assert.deepEqual(result.body, expectedResult);
          done();
        });
      });
      
      it('should put external resource as an array', function (done) {
        var resourceBody = [
          { "location": "West US", "tags": { "tag1": "value1", "tag2": "value3" }, "properties": { "pname": "Product1" } },
          { "location": "Building 44", "properties": { "pname": "Product2" } }
        ];
        testClient.putArray(resourceBody, function (error, result) {
          should.not.exist(error);
          done();
        });
      });
      
      it('should get and put external resource as a dictionary', function (done) {
        var expectedResult = {
          Product1: {
            id: '1',
            location: 'Building 44',
            name: 'Resource1',
            provisioningState: 'Succeeded',
            properties: {
              provisioningStateValues: 'OK',
              pname: 'Product1'
              ,
              tags: { tag1: 'value1', tag2: 'value3' },
              type: 'Microsoft.Web/sites'
            }
          }, 
          Product2: {
            id: '2', 
            name: 'Resource2', 
            location: 'Building 44'
          }, 
          Product3: {
            id: '3',
            name: 'Resource3'
          }
        };
        testClient.getDictionary(function (error, result) {
          should.not.exist(error);
          assert.deepEqual(result.body, expectedResult);
          done();
        });
      });
      
      it('should put external resource as a dictionary', function (done) {
        var resourceBody = {
          "Resource1": { "location": "West US", "tags": { "tag1": "value1", "tag2": "value3" }, "properties": { "pname": "Product1" } }, 
          "Resource2": { "location": "Building 44", "properties": { "pname": "Product2" } }
        };
        testClient.putDictionary(resourceBody, function (error, result) {
          should.not.exist(error);
          done();
        });
      });
      
      it('should get and put external resource as a complex type', function (done) {
        var expectedResult = {
          dictionaryofresources: {
            Product1: {
              id: '1',
              location: 'Building 44',
              name: 'Resource1',
              provisioningState: 'Succeeded',
              properties: {
                provisioningStateValues: 'OK',
                pname: 'Product1'
                ,
                tags: { tag1: 'value1', tag2: 'value3' },
                type: 'Microsoft.Web/sites'
              }
            }, 
            Product2: {
              id: '2', 
              name: 'Resource2', 
              location: 'Building 44'
            }, 
            Product3: {
              id: '3',
              name: 'Resource3'
            }
          },
          arrayofresources: [
            {
              id: '4',
              location: 'Building 44',
              name: 'Resource4',
              provisioningState: 'Succeeded',
              properties: {
                provisioningStateValues: 'OK',
                pname: 'Product4'
                ,
                tags: { tag1: 'value1', tag2: 'value3' },
                type: 'Microsoft.Web/sites'
              }
            }, 
            {
              id: '5', 
              name: 'Resource5', 
              location: 'Building 44'
            }, 
            {
              id: '6',
              name: 'Resource6'
            }
          ],
          productresource: {
            id: '7',
            name: 'Resource7',
            location: 'Building 44'
          }
        };
        testClient.getResourceCollection(function (error, result) {
          should.not.exist(error);
          assert.deepEqual(result.body, expectedResult);
          done();
        });
      });

      it('should put external resource as a complex type', function (done) {
        var resourceBody = {
          "arrayofresources": [
            {"location":"West US", "tags":{"tag1":"value1", "tag2":"value3"}, "properties":{"pname":"Product1"}},
            { "location": "East US", "properties": { "pname": "Product2" } }
          ],
          "dictionaryofresources": {
            "Resource1": { "location": "West US", "tags": { "tag1": "value1", "tag2": "value3" }, "properties": { "pname": "Product1" } }, 
            "Resource2": { "location": "Building 44", "properties": { "pname": "Product2" } }
          },
          "productresource": { "location": "India", "properties": { "pname": "Azure" } }
        };
        testClient.putResourceCollection(resourceBody, function (error, result) {
          should.not.exist(error);
          done();
        });
      });
    });
  });
});