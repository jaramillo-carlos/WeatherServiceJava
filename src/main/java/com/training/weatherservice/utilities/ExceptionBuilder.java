package com.training.weatherservice.utilities;

import com.training.weatherservice.dtos.ExceptionBody;
import lombok.Generated;
import lombok.NonNull;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Optional;

import static org.apache.commons.lang3.exception.ExceptionUtils.getRootCause;


@Generated
public class ExceptionBuilder {
    private final ExceptionBody exceptionBody;

    private ExceptionBuilder(Throwable exception) {
        StackTraceElement stackTrace = exception.getStackTrace()[0];

        this.exceptionBody =
                ExceptionBody
                        .init()
                        .date(
                                DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)
                                        .format(DateUtility.currentDate())
                        )
                        .line(String.valueOf(stackTrace.getLineNumber()))
                        .clazz(stackTrace.getClassName())
                        .method(stackTrace.getMethodName())
                        .message(exception.getMessage())
                        .endpoint(getCurrentEndpoint())
                        .messageDetail(
                                Optional.ofNullable(getRootCause(exception)).orElse(exception).getMessage()
                        )
                        .exceptionName(exception.getClass().getName())
                        .build();
    }

    public static String getCurrentEndpoint() {
        return ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes())
                .getRequest().getRequestURI();
    }

    public static ExceptionBuilder init(@NonNull Throwable exception) {
        return new ExceptionBuilder(exception);
    }

    public ExceptionBody build() {
        return exceptionBody;
    }
}
