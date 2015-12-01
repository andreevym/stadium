package ru.hello.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
public abstract class PersistentObject implements Id<Long>, Serializable {

    public PersistentObject() {
        // default
    }

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, updatable = false, nullable = false)
    private Long id;

    @Version
    @Column(name = "version")
    private int version = 0;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_update")
    private Date lastUpdate;

    @Override
    public Long getId() {
        return id;
    }

    @SuppressWarnings("unused")
    public void setId(final Long id) {
        this.id = id;
    }

    public int getVersion() {
        return version;
    }

    @SuppressWarnings("unused")
    public void setVersion(final int version) {
        this.version = version;
    }

    public Date getLastUpdate() {
        return new Date(lastUpdate.getTime());
    }

    public void setLastUpdate(final Date lastUpdate) {
        this.lastUpdate = new Date(lastUpdate.getTime());
    }

    protected void copy(final PersistentObject source) {
        setId(source.getId());
        setVersion(source.getVersion());
        setLastUpdate(source.getLastUpdate());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersistentObject that = (PersistentObject) o;

        if (version != that.version) return false;
        if (!id.equals(that.id)) return false;
        return !(lastUpdate != null ? !lastUpdate.equals(that.lastUpdate) : that.lastUpdate != null);

    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + version;
        result = 31 * result + (lastUpdate != null ? lastUpdate.hashCode() : 0);
        return result;
    }
}
