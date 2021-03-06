package com.mania.zerosheet.Items;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import com.mania.zerosheet.Transaction.Transaction;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Item implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long itemId;
    
    @NotBlank(message = "Item Name can not be Blank!")
    private String itemName;

    @NotBlank(message = "Measurement Unit can not be Blank!")
    private String unit;

    @PositiveOrZero(message = "Unit Price for loan can not be Negative")
    private double unitLoanPrice;

    @PositiveOrZero(message = "Unit Price for sale can not be Negative")
    private double unitPrice;

    @PositiveOrZero(message = "Total Quantity can not be Negative")
    private int totalQuantity;

    @Positive(message = "Area Coverage can not be Negative or Zero!")
    private double areaCoverage;

    @OneToMany(mappedBy = "item", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Transaction> transactions = new ArrayList<Transaction>();
    
    public Item(String itemName, String unit, double unitLoanPrice, double unitPrice, double areaCoverage, int totalQuantity)
    {
        this.itemName = itemName;
        this.unit = unit;
        this.unitLoanPrice = unitLoanPrice;
        this.unitPrice = unitPrice;
        this.totalQuantity = totalQuantity;
        this.areaCoverage = areaCoverage;
    }
}
