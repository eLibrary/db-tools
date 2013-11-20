package com.elib.entity;

// Generated Nov 16, 2013 10:36:05 PM by Hibernate Tools 4.0.0

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Book generated by hbm2java
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "book")
public class Book implements java.io.Serializable, IEntity<Integer> {

  private Integer id;
  private String title;
  private String author;
  private String series;
  private String edition;
  private String publisher;
  private Integer year;
  private String language;
  private String identifier;
  private Boolean landscape;
  private Boolean ocr;
  private Boolean kromsated;
  private Boolean color;
  private Boolean bookmarks;
  private Boolean kromsatedByScanmagic;
  private Integer dpi;
  private Integer pages;
  private String extension;
  private String filename;
  private Long filesize;
  private String absolutePath;
  private String downloadUrl;
  private Character md5;
  private Date timeAdded;
  private Date timeLastModified;
  private Set<Owner> owners = new HashSet<Owner>(0);
  private Set<UserLibrary> userlibraries = new HashSet<UserLibrary>(0);

  public Book() {
  }

  public Book(Date timeAdded) {
    this.timeAdded = timeAdded;
  }

  public Book(String title, String author, String series, String edition, String publisher, Integer year,
          String language, String identifier, Boolean landscape, Boolean ocr, Boolean kromsated, Boolean color,
          Boolean bookmarks, Boolean kromsatedByScanmagic, Integer dpi, Integer pages, String extension,
          String filename, Long filesize, String absolutePath, String downloadUrl, Character md5, Date timeAdded,
          Date timeLastModified, Set<Owner> owners, Set<UserLibrary> userlibraries) {
    this.title = title;
    this.author = author;
    this.series = series;
    this.edition = edition;
    this.publisher = publisher;
    this.year = year;
    this.language = language;
    this.identifier = identifier;
    this.landscape = landscape;
    this.ocr = ocr;
    this.kromsated = kromsated;
    this.color = color;
    this.bookmarks = bookmarks;
    this.kromsatedByScanmagic = kromsatedByScanmagic;
    this.dpi = dpi;
    this.pages = pages;
    this.extension = extension;
    this.filename = filename;
    this.filesize = filesize;
    this.absolutePath = absolutePath;
    this.downloadUrl = downloadUrl;
    this.md5 = md5;
    this.timeAdded = timeAdded;
    this.timeLastModified = timeLastModified;
    this.owners = owners;
    this.userlibraries = userlibraries;
  }

  @Id
  @GeneratedValue(strategy = IDENTITY)
  @Column(name = "ID", unique = true, nullable = false)
  public Integer getId() {
    return this.id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  @Column(name = "Title", length = 500)
  public String getTitle() {
    return this.title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  @Column(name = "Author", length = 300)
  public String getAuthor() {
    return this.author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  @Column(name = "Series", length = 200)
  public String getSeries() {
    return this.series;
  }

  public void setSeries(String series) {
    this.series = series;
  }

  @Column(name = "Edition", length = 50)
  public String getEdition() {
    return this.edition;
  }

  public void setEdition(String edition) {
    this.edition = edition;
  }

  @Column(name = "Publisher", length = 100)
  public String getPublisher() {
    return this.publisher;
  }

  public void setPublisher(String publisher) {
    this.publisher = publisher;
  }

  @Column(name = "Year")
  public Integer getYear() {
    return this.year;
  }

  public void setYear(Integer year) {
    this.year = year;
  }

  @Column(name = "Language", length = 20)
  public String getLanguage() {
    return this.language;
  }

  public void setLanguage(String language) {
    this.language = language;
  }

  @Column(name = "Identifier", length = 100)
  public String getIdentifier() {
    return this.identifier;
  }

  public void setIdentifier(String identifier) {
    this.identifier = identifier;
  }

  @Column(name = "Landscape")
  public Boolean getLandscape() {
    return this.landscape;
  }

  public void setLandscape(Boolean landscape) {
    this.landscape = landscape;
  }

  @Column(name = "Ocr")
  public Boolean getOcr() {
    return this.ocr;
  }

  public void setOcr(Boolean ocr) {
    this.ocr = ocr;
  }

  @Column(name = "Kromsated")
  public Boolean getKromsated() {
    return this.kromsated;
  }

  public void setKromsated(Boolean kromsated) {
    this.kromsated = kromsated;
  }

  @Column(name = "Color")
  public Boolean getColor() {
    return this.color;
  }

  public void setColor(Boolean color) {
    this.color = color;
  }

  @Column(name = "Bookmarks")
  public Boolean getBookmarks() {
    return this.bookmarks;
  }

  public void setBookmarks(Boolean bookmarks) {
    this.bookmarks = bookmarks;
  }

  @Column(name = "KromsatedByScanmagic")
  public Boolean getKromsatedByScanmagic() {
    return this.kromsatedByScanmagic;
  }

  public void setKromsatedByScanmagic(Boolean kromsatedByScanmagic) {
    this.kromsatedByScanmagic = kromsatedByScanmagic;
  }

  @Column(name = "Dpi")
  public Integer getDpi() {
    return this.dpi;
  }

  public void setDpi(Integer dpi) {
    this.dpi = dpi;
  }

  @Column(name = "Pages")
  public Integer getPages() {
    return this.pages;
  }

  public void setPages(Integer pages) {
    this.pages = pages;
  }

  @Column(name = "Extension", length = 5)
  public String getExtension() {
    return this.extension;
  }

  public void setExtension(String extension) {
    this.extension = extension;
  }

  @Column(name = "Filename", length = 1000)
  public String getFilename() {
    return this.filename;
  }

  public void setFilename(String filename) {
    this.filename = filename;
  }

  @Column(name = "Filesize")
  public Long getFilesize() {
    return this.filesize;
  }

  public void setFilesize(Long filesize) {
    this.filesize = filesize;
  }

  @Column(name = "AbsolutePath", length = 300)
  public String getAbsolutePath() {
    return this.absolutePath;
  }

  public void setAbsolutePath(String absolutePath) {
    this.absolutePath = absolutePath;
  }

  @Column(name = "DownloadUrl", length = 300)
  public String getDownloadUrl() {
    return this.downloadUrl;
  }

  public void setDownloadUrl(String downloadUrl) {
    this.downloadUrl = downloadUrl;
  }

  @Column(name = "MD5", length = 1)
  public Character getMd5() {
    return this.md5;
  }

  public void setMd5(Character md5) {
    this.md5 = md5;
  }

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "TimeAdded", nullable = false, length = 19)
  public Date getTimeAdded() {
    return this.timeAdded;
  }

  public void setTimeAdded(Date timeAdded) {
    this.timeAdded = timeAdded;
  }

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "TimeLastModified", length = 19)
  public Date getTimeLastModified() {
    return this.timeLastModified;
  }

  public void setTimeLastModified(Date timeLastModified) {
    this.timeLastModified = timeLastModified;
  }

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "book")
  public Set<Owner> getOwners() {
    return this.owners;
  }

  public void setOwners(Set<Owner> owners) {
    this.owners = owners;
  }

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "book")
  public Set<UserLibrary> getUserlibraries() {
    return this.userlibraries;
  }

  public void setUserlibraries(Set<UserLibrary> userlibraries) {
    this.userlibraries = userlibraries;
  }
  
  @Override
  public String toString() {
    return "Book [id=" + id + ", title=" + title + ", author=" + author + ", series=" + series + ", edition=" + edition
            + ", publisher=" + publisher + ", year=" + year + ", language=" + language + ", identifier=" + identifier
            + ", landscape=" + landscape + ", ocr=" + ocr + ", kromsated=" + kromsated + ", color=" + color
            + ", bookmarks=" + bookmarks + ", kromsatedByScanmagic=" + kromsatedByScanmagic + ", dpi=" + dpi
            + ", pages=" + pages + ", extension=" + extension + ", filename=" + filename + ", filesize=" + filesize
            + ", absolutePath=" + absolutePath + ", downloadUrl=" + downloadUrl + ", md5=" + md5 + ", timeAdded="
            + timeAdded + ", timeLastModified=" + timeLastModified + ", owners=" + owners + ", userlibraries="
            + userlibraries + "]";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((absolutePath == null) ? 0 : absolutePath.hashCode());
    result = prime * result + ((author == null) ? 0 : author.hashCode());
    result = prime * result + ((bookmarks == null) ? 0 : bookmarks.hashCode());
    result = prime * result + ((color == null) ? 0 : color.hashCode());
    result = prime * result + ((downloadUrl == null) ? 0 : downloadUrl.hashCode());
    result = prime * result + ((dpi == null) ? 0 : dpi.hashCode());
    result = prime * result + ((edition == null) ? 0 : edition.hashCode());
    result = prime * result + ((extension == null) ? 0 : extension.hashCode());
    result = prime * result + ((filename == null) ? 0 : filename.hashCode());
    result = prime * result + ((filesize == null) ? 0 : filesize.hashCode());
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    result = prime * result + ((identifier == null) ? 0 : identifier.hashCode());
    result = prime * result + ((kromsated == null) ? 0 : kromsated.hashCode());
    result = prime * result + ((kromsatedByScanmagic == null) ? 0 : kromsatedByScanmagic.hashCode());
    result = prime * result + ((landscape == null) ? 0 : landscape.hashCode());
    result = prime * result + ((language == null) ? 0 : language.hashCode());
    result = prime * result + ((md5 == null) ? 0 : md5.hashCode());
    result = prime * result + ((ocr == null) ? 0 : ocr.hashCode());
    result = prime * result + ((owners == null) ? 0 : owners.hashCode());
    result = prime * result + ((pages == null) ? 0 : pages.hashCode());
    result = prime * result + ((publisher == null) ? 0 : publisher.hashCode());
    result = prime * result + ((series == null) ? 0 : series.hashCode());
    result = prime * result + ((timeAdded == null) ? 0 : timeAdded.hashCode());
    result = prime * result + ((timeLastModified == null) ? 0 : timeLastModified.hashCode());
    result = prime * result + ((title == null) ? 0 : title.hashCode());
    result = prime * result + ((userlibraries == null) ? 0 : userlibraries.hashCode());
    result = prime * result + ((year == null) ? 0 : year.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Book other = (Book) obj;
    if (absolutePath == null) {
      if (other.absolutePath != null)
        return false;
    } else if (!absolutePath.equals(other.absolutePath))
      return false;
    if (author == null) {
      if (other.author != null)
        return false;
    } else if (!author.equals(other.author))
      return false;
    if (bookmarks == null) {
      if (other.bookmarks != null)
        return false;
    } else if (!bookmarks.equals(other.bookmarks))
      return false;
    if (color == null) {
      if (other.color != null)
        return false;
    } else if (!color.equals(other.color))
      return false;
    if (downloadUrl == null) {
      if (other.downloadUrl != null)
        return false;
    } else if (!downloadUrl.equals(other.downloadUrl))
      return false;
    if (dpi == null) {
      if (other.dpi != null)
        return false;
    } else if (!dpi.equals(other.dpi))
      return false;
    if (edition == null) {
      if (other.edition != null)
        return false;
    } else if (!edition.equals(other.edition))
      return false;
    if (extension == null) {
      if (other.extension != null)
        return false;
    } else if (!extension.equals(other.extension))
      return false;
    if (filename == null) {
      if (other.filename != null)
        return false;
    } else if (!filename.equals(other.filename))
      return false;
    if (filesize == null) {
      if (other.filesize != null)
        return false;
    } else if (!filesize.equals(other.filesize))
      return false;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    if (identifier == null) {
      if (other.identifier != null)
        return false;
    } else if (!identifier.equals(other.identifier))
      return false;
    if (kromsated == null) {
      if (other.kromsated != null)
        return false;
    } else if (!kromsated.equals(other.kromsated))
      return false;
    if (kromsatedByScanmagic == null) {
      if (other.kromsatedByScanmagic != null)
        return false;
    } else if (!kromsatedByScanmagic.equals(other.kromsatedByScanmagic))
      return false;
    if (landscape == null) {
      if (other.landscape != null)
        return false;
    } else if (!landscape.equals(other.landscape))
      return false;
    if (language == null) {
      if (other.language != null)
        return false;
    } else if (!language.equals(other.language))
      return false;
    if (md5 == null) {
      if (other.md5 != null)
        return false;
    } else if (!md5.equals(other.md5))
      return false;
    if (ocr == null) {
      if (other.ocr != null)
        return false;
    } else if (!ocr.equals(other.ocr))
      return false;
    if (owners == null) {
      if (other.owners != null)
        return false;
    } else if (!owners.equals(other.owners))
      return false;
    if (pages == null) {
      if (other.pages != null)
        return false;
    } else if (!pages.equals(other.pages))
      return false;
    if (publisher == null) {
      if (other.publisher != null)
        return false;
    } else if (!publisher.equals(other.publisher))
      return false;
    if (series == null) {
      if (other.series != null)
        return false;
    } else if (!series.equals(other.series))
      return false;
    if (timeAdded == null) {
      if (other.timeAdded != null)
        return false;
    } else if (!timeAdded.equals(other.timeAdded))
      return false;
    if (timeLastModified == null) {
      if (other.timeLastModified != null)
        return false;
    } else if (!timeLastModified.equals(other.timeLastModified))
      return false;
    if (title == null) {
      if (other.title != null)
        return false;
    } else if (!title.equals(other.title))
      return false;
    if (userlibraries == null) {
      if (other.userlibraries != null)
        return false;
    } else if (!userlibraries.equals(other.userlibraries))
      return false;
    if (year == null) {
      if (other.year != null)
        return false;
    } else if (!year.equals(other.year))
      return false;
    return true;
  }
  
  
}
