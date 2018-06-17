$(document).ready(function(){
    $('.donation-modify').on('click', function(){
        $(this).parents('tr').find('.donation-input').show();
        $(this).parents('tr').find('.donation-modify-btn').show();
        $(this).parents('tr').find('.donation-cancel').show();
        $(this).parents('tr').find('.donation-data').hide();
        $(this).parents('tr').find('.donation-delete').hide();
        $(this).hide();

    });

    

    $('.donation-cancel').on('click', function(){
        $(this).parents('tr').find('.donation-data').show();
        $(this).parents('tr').find('.donation-delete').show();
        $(this).parents('tr').find('.donation-input').hide();
        $(this).parents('tr').find('.donation-modify-btn').hide();
        $(this).hide();
        $(this).parents('tr').find('.donation-modify').show();
    });

    //Validation
    $('#login-form').submit(function(e) {
        
        var valid = true;

        var email = $('#login-form .valid-email').val();
        var password = $('#login-form .valid-pw').val();

        $(".error").text('');

        if (email.length < 1) {
            $('#login-form .valid-email + .error').text('Kötelező kitölteni!');
            valid = false;
        } else {
            var regEx_email = /([a-z0-9][a-z0-9._%+-]{1,63}@(?:[a-z0-9-]{2,63}\.){1,125}[a-z]{2,63})/;
            var validEmail = regEx_email.test(email);
            if (!validEmail) {
                $('#login-form .valid-email + .error').text('Érvénytelen formátum!');
                valid = false;
            }
        }

        if (password.length < 1) {
            $('#login-form .valid-pw + .error').text('Kötelező kitölteni!');
            valid = false;
        }
        
        if(!valid) {
            e.preventDefault();
        }
    });

    $('#registration-form').submit(function(e) {
        //e.preventDefault();
        var valid = true;

        var email = $('#registration-form .valid-email').val();
        var password = $('#registration-form .valid-pw').val();
        var name = $('#registration-form .valid-name').val();
        var bdate = $('#registration-form .valid-bdate').val();
        var taj = $('#registration-form .valid-taj').val();
        var gender = $('#registration-form .valid-gender').val();
        var weight = $('#registration-form .valid-weight').val();
        var rh = $('#registration-form .valid-rh').val();

        $(".error").text('');

        if (email.length < 1) {
            $('#registration-form .valid-email + .error').text('Kötelező kitölteni!');
            valid = false;
        } else {
            var regEx_email = /([a-z0-9][a-z0-9._%+-]{1,63}@(?:[a-z0-9-]{2,63}\.){1,125}[a-z]{2,63})/;
            var validEmail = regEx_email.test(email);
            if (!validEmail) {
                $('#registration-form .valid-email + .error').text('Érvénytelen formátum!');
                valid = false;
            }
        }

        if (password.length < 1) {
            $('#registration-form .valid-pw + .error').text('Kötelező kitölteni!');
            valid = false;
        }

        if (name.length < 1) {
            $('#registration-form .valid-name + .error').text('Kötelező kitölteni!');
            valid = false;
        } else {
            var regEx_name = /^[A-zöÖüÜóÓőŐúÚéÉáÁűŰíÍ' \-\.]*$/;
            var validName = regEx_name.test(name);
            if (!validName) {
                $('#registration-form .valid-name + .error').text('Érvénytelen formátum!');
                valid = false;
            }
        }

        if (bdate.length < 1) {
            $('#registration-form .valid-bdate + .error').text('Kötelező kitölteni!');
            valid = false;
        } else {
            var regEx_bdate = /^[1-2][0-9]{3}\-[0-1][0-9]\-[0-3][0-9]$/;
            var validBdate = regEx_bdate.test(bdate);
            if (!validBdate) {
                $('#registration-form .valid-bdate + .error').text('Érvénytelen formátum!');
                valid = false;
            }
        }

        if (taj.length < 1) {
            $('#registration-form .valid-taj + .error').text('Kötelező kitölteni!');
            valid = false;
        } else {
            var regEx_taj = /^[0-9]{3}[\s]?[\-]?[0-9]{3}[\s]?[\-]?[0-9]{3}$/;
            var validTaj = regEx_taj.test(taj);
            if (!validTaj) {
                $('#registration-form .valid-taj + .error').text('Érvénytelen formátum!');
                valid = false;
            }
        }
        /*
        if (gender.length < 1) {
            $('#registration-form .valid-gender + .error').text('Kötelező kitölteni!');
            valid = false;
        }*/
        
        if (weight.length < 1) {
            $('#registration-form .valid-weight + .error').text('Kötelező kitölteni!');
            valid = false;
        } else {
            var regEx_weight = /^[1-9]{1,3}[,\.]?[1-9]+$/;
            var validWeight = regEx_weight.test(weight);
            if (!validWeight) {
                $('#registration-form .valid-weight + .error').text('Csak számokat, illetve pont vagy vessző karaktert használj!');
                valid = false;
            }
        }
        /*
        if (rh.length < 1) {
            $('#registration-form .valid-rh + .error').text('Kötelező kitölteni!');
            valid = false;
        }*/

        if(!valid) {
            e.preventDefault();
        }
    });
    
    $('#profile-uform').submit(function(e) {
        //e.preventDefault();
        var valid = true;

        var email = $('#profile-form .valid-email').val();
        var password = $('#profile-form .valid-pw').val();
        var name = $('#profile-form .valid-name').val();
        var bdate = $('#profile-form .valid-bdate').val();
        var taj = $('#profile-form .valid-taj').val();
        var gender = $('#profile-form .valid-gender').val();
        var weight = $('#profile-form .valid-weight').val();
        var rh = $('#profile-form .valid-rh').val();

        $(".error").text('');

        if (email.length < 1) {
            $('#profile-form .valid-email + .error').text('Kötelező kitölteni!');
            valid = false;
        } else {
            var regEx_email = /([a-z0-9][a-z0-9._%+-]{1,63}@(?:[a-z0-9-]{2,63}\.){1,125}[a-z]{2,63})/;
            var validEmail = regEx_email.test(email);
            if (!validEmail) {
                $('#profile-form .valid-email + .error').text('Érvénytelen formátum!');
                valid = false;
            }
        }

        if (password.length < 1) {
            $('#profile-form .valid-pw + .error').text('Kötelező kitölteni az adatok mentéséhez!');
            valid = false;
        }

        if (name.length < 1) {
            $('#profile-form .valid-name + .error').text('Kötelező kitölteni!');
            valid = false;
        } else {
            var regEx_name = /^[A-zöÖüÜóÓőŐúÚéÉáÁűŰíÍ' \-\.]*$/;
            var validName = regEx_name.test(name);
            if (!validName) {
                $('#profile-form .valid-name + .error').text('Érvénytelen formátum!');
                valid = false;
            }
        }

        if (bdate.length < 1) {
            $('#profile-form .valid-bdate + .error').text('Kötelező kitölteni!');
            valid = false;
        } else {
            var regEx_bdate = /^[1-2][0-9]{3}\-[0-1][0-9]\-[0-3][0-9]$/;
            var validBdate = regEx_bdate.test(bdate);
            if (!validBdate) {
                $('#profile-form .valid-bdate + .error').text('Érvénytelen formátum!');
                valid = false;
            }
        }

        if (taj.length < 1) {
            $('#profile-form .valid-taj + .error').text('Kötelező kitölteni!');
            valid = false;
        } else {
            var regEx_taj = /^[0-9]{3}[\s]?[\-]?[0-9]{3}[\s]?[\-]?[0-9]{3}$/;
            var validTaj = regEx_taj.test(taj);
            if (!validTaj) {
                $('#profile-form .valid-taj + .error').text('Érvénytelen formátum!');
                valid = false;
            }
        }

        if (weight.length < 1) {
            $('#profile-form .valid-weight + .error').text('Kötelező kitölteni!');
            valid = false;
        } else {
            var regEx_weight = /^[1-9]{1,3}[,\.]?[1-9]+$/;
            var validWeight = regEx_weight.test(weight);
            if (!validWeight) {
                $('#profile-form .valid-weight + .error').text('Csak számokat, illetve pont vagy vessző karaktert használj!');
                valid = false;
            }
        }

        if(!valid) {
            e.preventDefault();
        }
    });
    
    $('#donation-form').submit(function(e) {
        
        var valid = true;

        var location = $('#donation-form .valid-location').val();
        var time = $('#donation-form .valid-time').val();

        $(".error").text('');

        if (location.length < 1) {
            $('#donation-form .valid-location + .error').text('Kötelező kitölteni!');
            valid = false;
        }

        if (time.length < 1) {
            $('#donation-form .valid-time + .error').text('Kötelező kitölteni!');
            valid = false;
        } else {
            var regEx_time = /^[1-2][0-9]{3}\-[0-1][0-9]\-[0-3][0-9]$/;
            var validTime = regEx_time.test(time);
            if (!validTime) {
                $('#donation-form .valid-time + .error').text('Érvénytelen formátum!');
                valid = false;
            }
        }
        
        if(!valid) {
            e.preventDefault();
        }
    });
    
    $('#modify-form').submit(function(e) {
        
        var valid = true;

        var location = $('#modify-form .valid-mod-location').val();
        var time = $('#modify-form .valid-mod-time').val();

        if (location.length < 1) {
            $('#modify-form .valid-mod-location').addClass('error-border');
            valid = false;
        }

        if (time.length < 1) {
            $('#modify-form .valid-mod-time').addClass('error-border');
            valid = false;
        } else {
            var regEx_time = /^[1-2][0-9]{3}\-[0-1][0-9]\-[0-3][0-9]$/;
            var validTime = regEx_time.test(time);
            if (!validTime) {
                $('#modify-form .valid-mod-time').addClass('error-border');
                valid = false;
            }
        }
        
        if(!valid) {
            e.preventDefault();
        } else {
            $('#modify-form .valid-mod-location').removeClass('error-border');
            $('#modify-form .valid-mod-time').removeClass('error-border');
            $(this).parents('tr').find('.donation-data').show();
            $(this).parents('tr').find('.donation-delete').show();
            $(this).parents('tr').find('.donation-input').hide();
            $(this).parents('tr').find('.donation-cancel').hide();
            $(this).hide();
            $(this).parents('tr').find('.donation-modify').show();
        }
    });
});


