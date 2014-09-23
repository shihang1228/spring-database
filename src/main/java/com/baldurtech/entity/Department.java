package com.baldurtech.entity;

public class Department
{
    private Long id;
    private String name;
    private String memo;
    private String parent;
    private String address;

    public void setId(Long id)
    {
        this.id = id;
    }
    public Long getId()
    {
        return this.id;
    }
     
    public void setName(String name)
    {
        this.name = name;
    }
    public String getName()
    {
        return this.name;
    }

    public void setMemo(String memo)
    {
        this.memo = memo;
    }
    public String getMemo()
    {
        return this.memo;
    }
     
    public void setParent(String parent)
    {
        this.parent = parent;
    }
    public String getParent()
    {
        return this.parent;
    }
          
    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getAddress()
    {
        return this.address;
    }

}

