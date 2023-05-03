package org.stanislav.spring.config.locale;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/**
 * @author Stanislav Hlova
 */
public class ChainLocaleResolver extends AcceptHeaderLocaleResolver {

    List<Locale> LOCALES = Arrays.asList(new Locale("en"),new Locale("uk_UA"));
    private List<LocaleResolver> localeResolvers;
    public ChainLocaleResolver() {
        localeResolvers = new ArrayList<>();
        CookieLocaleResolver cookieLocaleResolver = new CookieLocaleResolver();
        cookieLocaleResolver.setDefaultLocale(Locale.US);
        AcceptHeaderLocaleResolver acceptHeaderLocaleResolver = new AcceptHeaderLocaleResolver();
        localeResolvers.add(cookieLocaleResolver);
        localeResolvers.add(acceptHeaderLocaleResolver);
    }

    @Override
    public Locale resolveLocale(HttpServletRequest request) {

        Locale locale = null;
        locale = localeResolvers.get(0).resolveLocale(request);
        if(locale !=null){
            return locale;
        }
        locale = localeResolvers.get(1).resolveLocale(request);
        if(locale!=null){
            return locale;
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {
        super.setLocale(request, response, locale);
    }

}
