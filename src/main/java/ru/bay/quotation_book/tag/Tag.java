package ru.bay.quotation_book.tag;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import ru.bay.quotation_book.core.Status;
import ru.bay.quotation_book.core.annotation.Binder;

@Getter
@ToString(exclude = {"id"})
@EqualsAndHashCode(exclude = "status")
@RequiredArgsConstructor
class Tag implements Binder {
    private final int id;
    private final String name;
    @Setter
    private Status status;

    @JsonCreator
    public static Tag fromJson(
            @JsonProperty("id") int id,
            @JsonProperty("name") String name,
            @JsonProperty("status") Status status
    ) {
        var tag = new Tag(id, name);
        tag.setStatus(status);
        return tag;
    }

    @Override
    public void deactivate() {
        setStatus(Status.INACTIVE);
    }
}
