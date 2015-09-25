/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battlefield;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Adriel
 */
@Entity
@Table(name = "users")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Users.findAll", query = "SELECT u FROM Users u"),
    @NamedQuery(name = "Users.findByUserName", query = "SELECT u FROM Users u WHERE u.userName = :userName"),
    @NamedQuery(name = "Users.findByBalance", query = "SELECT u FROM Users u WHERE u.balance = :balance"),
    @NamedQuery(name = "Users.findBy\ufb01rstName", query = "SELECT u FROM Users u WHERE u.\ufb01rstName = :\ufb01rstName"),
    @NamedQuery(name = "Users.findByLastName", query = "SELECT u FROM Users u WHERE u.lastName = :lastName"),
    @NamedQuery(name = "Users.findByIban", query = "SELECT u FROM Users u WHERE u.iban = :iban"),
    @NamedQuery(name = "Users.findByCharacterSlots", query = "SELECT u FROM Users u WHERE u.characterSlots = :characterSlots"),
    @NamedQuery(name = "Users.findByLastPayment", query = "SELECT u FROM Users u WHERE u.lastPayment = :lastPayment"),
    @NamedQuery(name = "Users.findByMonthsPayed", query = "SELECT u FROM Users u WHERE u.monthsPayed = :monthsPayed"),
    @NamedQuery(name = "Users.findByPassword", query = "SELECT u FROM Users u WHERE u.password = :password"),
    @NamedQuery(name = "Users.findByBanned", query = "SELECT u FROM Users u WHERE u.banned = :banned")})
public class Users implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "user_name")
    private String userName;
    @Basic(optional = false)
    @Column(name = "balance")
    private int balance;
    @Column(name = "\ufb01rst_name")
    private Character ﬁrstName;
    @Column(name = "last_name")
    private Character lastName;
    @Column(name = "iban")
    private Character iban;
    @Column(name = "character_slots")
    private Character characterSlots;
    @Column(name = "last payment")
    @Temporal(TemporalType.DATE)
    private Date lastPayment;
    @Column(name = "months payed")
    @Temporal(TemporalType.DATE)
    private Date monthsPayed;
    @Column(name = "password")
    private String password;
    @Column(name = "banned")
    private Boolean banned;
    @ManyToMany(mappedBy = "usersCollection")
    private Collection<Characters> charactersCollection;
    @ManyToMany(mappedBy = "usersCollection")
    private Collection<Servers> serversCollection;

    public Users() {
    }

    public Users(String userName) {
        this.userName = userName;
    }

    public Users(String userName, int balance) {
        this.userName = userName;
        this.balance = balance;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public Character getﬁrstName() {
        return ﬁrstName;
    }

    public void setﬁrstName(Character ﬁrstName) {
        this.ﬁrstName = ﬁrstName;
    }

    public Character getLastName() {
        return lastName;
    }

    public void setLastName(Character lastName) {
        this.lastName = lastName;
    }

    public Character getIban() {
        return iban;
    }

    public void setIban(Character iban) {
        this.iban = iban;
    }

    public Character getCharacterSlots() {
        return characterSlots;
    }

    public void setCharacterSlots(Character characterSlots) {
        this.characterSlots = characterSlots;
    }

    public Date getLastPayment() {
        return lastPayment;
    }

    public void setLastPayment(Date lastPayment) {
        this.lastPayment = lastPayment;
    }

    public Date getMonthsPayed() {
        return monthsPayed;
    }

    public void setMonthsPayed(Date monthsPayed) {
        this.monthsPayed = monthsPayed;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getBanned() {
        return banned;
    }

    public void setBanned(Boolean banned) {
        this.banned = banned;
    }

    @XmlTransient
    public Collection<Characters> getCharactersCollection() {
        return charactersCollection;
    }

    public void setCharactersCollection(Collection<Characters> charactersCollection) {
        this.charactersCollection = charactersCollection;
    }

    @XmlTransient
    public Collection<Servers> getServersCollection() {
        return serversCollection;
    }

    public void setServersCollection(Collection<Servers> serversCollection) {
        this.serversCollection = serversCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userName != null ? userName.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Users)) {
            return false;
        }
        Users other = (Users) object;
        if ((this.userName == null && other.userName != null) || (this.userName != null && !this.userName.equals(other.userName))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "battlefield.Users[ userName=" + userName + " ]";
    }
    
}
