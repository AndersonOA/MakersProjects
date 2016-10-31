$(function() {
	
	// URL API
	var sAction = 'http://' + window.location.host + '/makersweb-websocket/api/';
	
	// Coloca todos os formulários em AJAX mode e inicia LOAD ao submeter!
	$('form').not('.ajax_off').submit(function() {
		var form = $(this);
		var callback = form.find('input[name="callback"]').val();
		
		$.ajax({
			url : sAction + callback,
			data : JSON.stringify(form.serializeObject()),
			type : "POST",
			contentType : "application/json",
			beforeSend : function() {
				form.find('.form_load').fadeIn('slow');
				$('.trigger_ajax').fadeOut('fast');
			},
			success : function(response) {
				console.clear();
				
				// REMOVE LOAD
				form.find('.form_load').fadeOut("fast", function() {
					console.log(response);
					// EXIBE CALLBACKS
					if (response.message) {
						console.log(response.message);
						var CallBackPresent = form.find('.callback_return');
						if (CallBackPresent.length) {
							CallBackPresent.html(response.message);
							$('.trigger_ajax').fadeIn('slow');
							if (response.typeError === 'success') {
								form.reset();
							}
						} else {
							Trigger(response.message);
							if (response.typeError === 'success') {
								form.reset();
							}
						}
					}
					
					//REDIRECIONA
                    if (response.redirect) {
                        window.setTimeout(function () {
                            window.location.href = response.redirect;
                        }, 500);
                    }
				});
			}
		}); 
		return false;
	});
	
	// Adiciona LoadGif ao lado do submit em todos os formulários do sistema
	// automaticamente
	$('form .btn').before('');

	// Ocultra Trigger clicada
	$('html').on('click', '.trigger_ajax, .trigger_modal', function() {
		$(this).fadeOut('slow', function() {
			$(this).remove();
		});
	});
	
});//jQuery

//############## MODAL MESSAGE
function Trigger(Message) {
	$('.trigger_ajax').fadeOut('fast', function() {
		$(this).remove();
	});

	$('.dashboard_main').before(
			"<div class='trigger_modal'>" + Message + "</div>");
	$('.trigger_ajax').fadeIn('slow');
}

//############## SERIALIZE FORM JSON
$.fn.serializeObject = function() {
	var o = {};
	var a = this.serializeArray();
	$.each(a, function() {
		if (o[this.name] !== undefined) {
			if (!o[this.name].push) {
				o[this.name] = [ o[this.name] ];
			}
			o[this.name].push(this.value || '');
		} else {
			o[this.name] = this.value || '';
		}
	});
	return o;
};

// Function Reset Criada para resetar os formularios nas modais
jQuery.fn.reset = function() {
	this.each(function() {
		if ($(this).is('form')) {
			var button = jQuery(jQuery('<input type="reset" />'));
			button.hide();
			$(this).append(button);
			button.click().remove();
		} else if ($(this).parent('form').size()) {
			var button = jQuery(jQuery('<input type="reset" />'));
			button.hide();
			$(this).parent('form').append(button);
			button.click().remove();
		} else if ($(this).find('form').size()) {
			$(this).find('form').each(function() {
				var button = jQuery(jQuery('<input type="reset" />'));
				button.hide();
				$(this).append(button);
				button.click().remove();
			});
		}
	});

	return this;
};