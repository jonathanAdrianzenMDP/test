/// <summary>
/// Script de Controladora de la Vista 
/// </summary>
/// <remarks>
/// </remarks>
try {
    ns('SIGPI.dashboard.Index.Controller');
    SIGPI.dashboard.Index.Controller = function () {
        var base = this;
        base.Ini = function () {
            'use strict';
            base.Event.changePrintCharts();
            base.Control.txtAnio().on('change', base.Event.changePrintCharts);
            
        };

        base.Parametros = {
            
        };

        base.Control = {
            txtAnio: function () {
                return $('#txtanio');
            },
            lblCantIOARR: function () {
                return $('[name=lblCantIOARR]');
            },
            lblCantPIP: function () {
                return $('[name=lblCantPIP]');
            },
            lblCostoIOARR: function () {
                return $('[name=lblCostoIOARR]');
            },
            lblCostoPIP: function () {
                return $('[name=lblCostoPIP]');
            }
        };

        base.Event = {
            changePrintCharts: function () {
                base.Ajax.getTotalIdeas(base.Control.txtAnio().val());
                base.Ajax.getCostoTotalIdeas(base.Control.txtAnio().val());
                base.Ajax.getTotalFuenteFinanciamiento(base.Control.txtAnio().val());
            }
        	            
        };
        base.Ajax = {
            getTotalIdeas: function (anio) {
                $.ajax({
                    "url": 'getTotalIdeas',
                    "type": 'POST',
                    async: false,
                    "data": {"anio": anio},
                    success: function (res) {
                        console.log(res.data);
                        base.Function.getCantidadTotalIdeas.setDataArray(res.data);
                        base.Function.getCantidadTotalIdeas.setLabel(res.data);
                    }
                });
            },
            getCostoTotalIdeas: function (anio) {
                $.ajax({
                    "url": 'getCostoTotalIdeas',
                    "type": 'POST',
                    async: false,
                    "data": {"anio": anio},
                    success: function (res) {
                        console.log(res.data);
                        base.Function.getCostoTotalIdeas.setDataArray(res.data);
                        base.Function.getCostoTotalIdeas.setLabel(res.data);
                    }
                });
            },
            getTotalFuenteFinanciamiento: function (anio) {
                $.ajax({
                    "url": 'getTotalFuenteFinanc',
                    "type": 'POST',
                    async: false,
                    "data": {"anio": anio},
                    success: function (res) {
                        console.log(res.data);
                        base.Function.getTotalFuenteFinanciamiento.setCategories(res.data);
                    }
                });
            }
        };
        base.Function = {
           setNumberDecimal: function(){
               $('.number').number(true,2);
           },
           getCostoTotalIdeas : {
               setLabel: function(data){
                   var totalCostoIOARR = 0;
                   base.Control.lblCostoPIP().text(0);
                   $.each(data, function(i, item){
                      if(i == 0){
                          base.Control.lblCostoPIP().text(parseFloat(item.costo));
                      }else{
                         totalCostoIOARR += parseFloat(item.costo);
                      }
                   });
                    base.Control.lblCostoIOARR().text(totalCostoIOARR);
                    base.Function.setNumberDecimal();
               },
               setDataArray: function(data){
                   var arrayData = new Array();
                   var arrayLabel = new Array();
                   
                   $.each(data, function(i, item){               
                       arrayData.push(parseFloat(item.costo));
                   });
                  
                   $.each(data, function(i, item){
                       arrayLabel.push(item.tipo);
                   });
                   
                   base.Function.getCostoTotalIdeas.setChartPie(arrayData, arrayLabel);
               },
               setChartPie: function(data, labels){
                   
                   var ctx = document.getElementsByClassName("chartBar");
                    var myBarChart = new Chart(ctx, {
                    type: 'horizontalBar',
                    data: {
                      labels: labels,
                      datasets: [{
                        label: "Costo de Inversion",
                        backgroundColor: "#4e73df",
                        hoverBackgroundColor: "#2e59d9",
                        borderColor: "#4e73df",
                        data: data
                      }]
                    },
                    options: {
                      maintainAspectRatio: false,
                      layout: {
                        padding: {
                          left: 10,
                          right: 25,
                          top: 25,
                          bottom: 0
                        }
                      },
                      scales: {
                        xAxes: [{
                         
                          gridLines: {
                            display: false,
                            drawBorder: false
                          },
                          ticks: {
                            //maxTicksLimit: 6
                            
                            beginAtZero:true,
                            callback: function(value, index, values) {
                              return 'S/ ' + number_format(value);
                            }
                          },
                          //maxBarThickness: 25,
                          
                        }],
                        yAxes: [{
                          ticks: {
                            //min: 0,
                            //max: 15000,
                            //maxTicksLimit: 10,
                            padding: 10,
                            // Include a dollar sign in the ticks
                            
                          },
                          gridLines: {
                            color: "rgb(234, 236, 244)",
                            zeroLineColor: "rgb(234, 236, 244)",
                            drawBorder: false,
                            borderDash: [2],
                            zeroLineBorderDash: [2]
                          }
                        }],
                      },
                      legend: {
                        display: false
                      },
                      tooltips: {
                        titleMarginBottom: 10,
                        titleFontColor: '#6e707e',
                        titleFontSize: 14,
                        backgroundColor: "rgb(255,255,255)",
                        bodyFontColor: "#858796",
                        borderColor: '#dddfeb',
                        borderWidth: 1,
                        xPadding: 15,
                        yPadding: 15,
                        displayColors: false,
                        caretPadding: 10,
                        callbacks: {
                          label: function(tooltipItem, chart) {
                            var datasetLabel = chart.datasets[tooltipItem.datasetIndex].label || '';
                            return datasetLabel + ': S/ ' + number_format(tooltipItem.xLabel);
                          }
                        }
                      }
                    }
                  });

                
                }
           },
           getCantidadTotalIdeas : {
               setLabel: function(data){
                   base.Control.lblCantPIP().text(0);
                   base.Control.lblCantIOARR().text(0);
                   $.each(data, function(i, item){
                      if(item.tipo == 'PIP'){
                          base.Control.lblCantPIP().text(item.total);
                      }else{
                          base.Control.lblCantIOARR().text(item.total);
                      }
                   });
               },
               setDataArray: function(data){
                   var arrayData = new Array();
                   var arrayLabel = new Array();
                   $.each(data, function(i, item){
                       arrayData.push(item.total);
                   });
                   $.each(data, function(i, item){
                       arrayLabel.push(item.tipo);
                   });
                   base.Function.getCantidadTotalIdeas.setChartPie(arrayData, arrayLabel);
               },
               setChartPie: function(data, labels){
                var ctx = document.getElementById("myPieChart");
                var myPieChart = new Chart(ctx, {
                  type: 'doughnut',
                  data: {
                    labels: labels,
                    datasets: [{
                      data: data,
                      backgroundColor: ['#4e73df', '#1cc88a', '#36b9cc'],
                      hoverBackgroundColor: ['#2e59d9', '#17a673', '#2c9faf'],
                      hoverBorderColor: "rgba(234, 236, 244, 1)",
                    }],
                  },
                  options: {
                    maintainAspectRatio: false,
                    tooltips: {
                      backgroundColor: "rgb(255,255,255)",
                      bodyFontColor: "#858796",
                      borderColor: '#dddfeb',
                      borderWidth: 1,
                      xPadding: 15,
                      yPadding: 15,
                      displayColors: false,
                      caretPadding: 10,
                    },
                    legend: {
                      display: true
                    },
                    cutoutPercentage: 80,
                  },
                });
           }
           },
           getTotalFuenteFinanciamiento: {
                setCategories: function(data){
                    var arrayCategories = new Array();
                    var arrayDataRecurso_ordinario = new Array();
                    var arrayDataDonacion_transferencia = new Array();
                    var arrayDataRecurso_direc_recaudado = new Array();
                    var arrayDataRecurso_operacion = new Array();
                    var arrayDataRecurso_determinado = new Array();
                    
                    $.each(data, function(i, obj){
                        arrayCategories.push(obj.tipo);
                        arrayDataRecurso_ordinario.push(obj.recurso_ordinario);
                        arrayDataDonacion_transferencia.push(obj.donacion_transferencia);
                        arrayDataRecurso_direc_recaudado.push(obj.recurso_direc_recaudado);
                        arrayDataRecurso_operacion.push(obj.recurso_operacion);
                        arrayDataRecurso_determinado.push(obj.recurso_determinado);
                    });
                    var objSerie = {
                        arrayDataRecurso_ordinario: arrayDataRecurso_ordinario,
                        arrayDataDonacion_transferencia: arrayDataDonacion_transferencia,
                        arrayDataRecurso_direc_recaudado: arrayDataRecurso_direc_recaudado,
                        arrayDataRecurso_operacion: arrayDataRecurso_operacion,
                        arrayDataRecurso_determinado: arrayDataRecurso_determinado
                    }
                    base.Function.getTotalFuenteFinanciamiento.setChart(arrayCategories, objSerie);
                },
                setChart: function(arrayCategories, objSerie){
                        var anio = base.Control.txtAnio().val();
                        Highcharts.chart('chartBarFuenteFinanciero', {
                            chart: {
                                type: 'column'
                            },
                            title: {
                                text: 'Costos totales de Fuentes de Financiamiento del ' + anio
                            },
                            subtitle: {
                                text: 'Fuente: Sistema de Gestion de Inversiones FAP - SIGIN'
                            },
                            xAxis: {
                                categories: arrayCategories,
                                title: {
                                    text: null
                                }
                            },
                            yAxis: {
                                crosshair: true,
                                min: 0,
                                title: {
                                    text: 'Total (soles)'
                                },
                                labels: {
                                    overflow: 'justify'
                                }
                            },
                            tooltip: {
                               pointFormat: '{series.name}: <b>S/. {point.y: .2f}</b>' 
                            },
                            plotOptions: {
                                bar: {
                                    dataLabels: {
                                        enabled: true
                                    }
                                }
                            },
                            legend: {
                                layout: 'horizontal',
                                align: 'center',
                                verticalAlign: 'bottom',
                                floating: false,
                                borderWidth: 1,
                                backgroundColor:
                                    Highcharts.defaultOptions.legend.backgroundColor || '#FFFFFF',
                                shadow: true
                            },
                           
                            series: [{
                                name: 'DONACION Y TRANSFERENCIA',
                                data: objSerie.arrayDataDonacion_transferencia
                            }, {
                                name: 'RECURSOS DETERMINADOS',
                                data: objSerie.arrayDataRecurso_determinado
                            }, {
                                name: 'RECURSOS DE OPERACIONES OFICIALES DE CREDITO',
                                data: objSerie.arrayDataRecurso_operacion
                            }, {
                                name: 'RECURSO ORDINARIO',
                                data: objSerie.arrayDataRecurso_ordinario
                            }, {
                                name: 'RECURSO DIRECTAMENTE RECAUDADOS',
                                data: objSerie.arrayDataRecurso_direc_recaudado
                            }]
                        });
               }
           }
        };
           
    };
} catch (ex) {
    alert(ex.message);
}


