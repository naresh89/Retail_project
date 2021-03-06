package oracle.retail.apps.aipdt.cds.model.view;

import java.math.BigDecimal;

import oracle.jbo.server.AttributeDefImpl;

import oracle.retail.apps.aipdt.common.adfbc.AipdtViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Thu Mar 24 15:10:06 IST 2016
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class CrossDockSetupRowDOWVORowImpl extends AipdtViewRowImpl {
    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        Id {
            public Object get(CrossDockSetupRowDOWVORowImpl obj) {
                return obj.getId();
            }

            public void put(CrossDockSetupRowDOWVORowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ,
        DowSeq {
            public Object get(CrossDockSetupRowDOWVORowImpl obj) {
                return obj.getDowSeq();
            }

            public void put(CrossDockSetupRowDOWVORowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ,
        DowType {
            public Object get(CrossDockSetupRowDOWVORowImpl obj) {
                return obj.getDowType();
            }

            public void put(CrossDockSetupRowDOWVORowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ,
        Sunday {
            public Object get(CrossDockSetupRowDOWVORowImpl obj) {
                return obj.getSunday();
            }

            public void put(CrossDockSetupRowDOWVORowImpl obj, Object value) {
                obj.setSunday((Integer) value);
            }
        }
        ,
        Monday {
            public Object get(CrossDockSetupRowDOWVORowImpl obj) {
                return obj.getMonday();
            }

            public void put(CrossDockSetupRowDOWVORowImpl obj, Object value) {
                obj.setMonday((Integer) value);
            }
        }
        ,
        Tuesday {
            public Object get(CrossDockSetupRowDOWVORowImpl obj) {
                return obj.getTuesday();
            }

            public void put(CrossDockSetupRowDOWVORowImpl obj, Object value) {
                obj.setTuesday((Integer) value);
            }
        }
        ,
        Wednesday {
            public Object get(CrossDockSetupRowDOWVORowImpl obj) {
                return obj.getWednesday();
            }

            public void put(CrossDockSetupRowDOWVORowImpl obj, Object value) {
                obj.setWednesday((Integer) value);
            }
        }
        ,
        Thursday {
            public Object get(CrossDockSetupRowDOWVORowImpl obj) {
                return obj.getThursday();
            }

            public void put(CrossDockSetupRowDOWVORowImpl obj, Object value) {
                obj.setThursday((Integer) value);
            }
        }
        ,
        Friday {
            public Object get(CrossDockSetupRowDOWVORowImpl obj) {
                return obj.getFriday();
            }

            public void put(CrossDockSetupRowDOWVORowImpl obj, Object value) {
                obj.setFriday((Integer) value);
            }
        }
        ,
        Saturday {
            public Object get(CrossDockSetupRowDOWVORowImpl obj) {
                return obj.getSaturday();
            }

            public void put(CrossDockSetupRowDOWVORowImpl obj, Object value) {
                obj.setSaturday((Integer) value);
            }
        }
        ;
        private static AttributesEnum[] vals = null;
        private static final int firstIndex = 0;

        public abstract Object get(CrossDockSetupRowDOWVORowImpl object);

        public abstract void put(CrossDockSetupRowDOWVORowImpl object, Object value);

        public int index() {
            return AttributesEnum.firstIndex() + ordinal();
        }

        public static final int firstIndex() {
            return firstIndex;
        }

        public static int count() {
            return AttributesEnum.firstIndex() + AttributesEnum.staticValues().length;
        }

        public static final AttributesEnum[] staticValues() {
            if (vals == null) {
                vals = AttributesEnum.values();
            }
            return vals;
        }
    }


    public static final int ID = AttributesEnum.Id.index();
    public static final int DOWSEQ = AttributesEnum.DowSeq.index();
    public static final int DOWTYPE = AttributesEnum.DowType.index();
    public static final int SUNDAY = AttributesEnum.Sunday.index();
    public static final int MONDAY = AttributesEnum.Monday.index();
    public static final int TUESDAY = AttributesEnum.Tuesday.index();
    public static final int WEDNESDAY = AttributesEnum.Wednesday.index();
    public static final int THURSDAY = AttributesEnum.Thursday.index();
    public static final int FRIDAY = AttributesEnum.Friday.index();
    public static final int SATURDAY = AttributesEnum.Saturday.index();

    /**
     * This is the default constructor (do not remove).
     */
    public CrossDockSetupRowDOWVORowImpl() {
    }

    /**
     * Gets the attribute value for the calculated attribute Id.
     * @return the Id
     */
    public BigDecimal getId() {
        return (BigDecimal) getAttributeInternal(ID);
    }

    /**
     * Gets the attribute value for the calculated attribute DowSeq.
     * @return the DowSeq
     */
    public BigDecimal getDowSeq() {
        return (BigDecimal) getAttributeInternal(DOWSEQ);
    }

    /**
     * Gets the attribute value for the calculated attribute DowType.
     * @return the DowType
     */
    public String getDowType() {
        return (String) getAttributeInternal(DOWTYPE);
    }

    /**
     * Gets the attribute value for the calculated attribute Sunday.
     * @return the Sunday
     */
    public Integer getSunday() {
        return (Integer) getAttributeInternal(SUNDAY);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute Sunday.
     * @param value value to set the  Sunday
     */
    public void setSunday(Integer value) {
        setAttributeInternal(SUNDAY, value);
    }

    /**
     * Gets the attribute value for the calculated attribute Monday.
     * @return the Monday
     */
    public Integer getMonday() {
        return (Integer) getAttributeInternal(MONDAY);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute Monday.
     * @param value value to set the  Monday
     */
    public void setMonday(Integer value) {
        setAttributeInternal(MONDAY, value);
    }

    /**
     * Gets the attribute value for the calculated attribute Tuesday.
     * @return the Tuesday
     */
    public Integer getTuesday() {
        return (Integer) getAttributeInternal(TUESDAY);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute Tuesday.
     * @param value value to set the  Tuesday
     */
    public void setTuesday(Integer value) {
        setAttributeInternal(TUESDAY, value);
    }

    /**
     * Gets the attribute value for the calculated attribute Wednesday.
     * @return the Wednesday
     */
    public Integer getWednesday() {
        return (Integer) getAttributeInternal(WEDNESDAY);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute Wednesday.
     * @param value value to set the  Wednesday
     */
    public void setWednesday(Integer value) {
        setAttributeInternal(WEDNESDAY, value);
    }

    /**
     * Gets the attribute value for the calculated attribute Thursday.
     * @return the Thursday
     */
    public Integer getThursday() {
        return (Integer) getAttributeInternal(THURSDAY);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute Thursday.
     * @param value value to set the  Thursday
     */
    public void setThursday(Integer value) {
        setAttributeInternal(THURSDAY, value);
    }

    /**
     * Gets the attribute value for the calculated attribute Friday.
     * @return the Friday
     */
    public Integer getFriday() {
        return (Integer) getAttributeInternal(FRIDAY);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute Friday.
     * @param value value to set the  Friday
     */
    public void setFriday(Integer value) {
        setAttributeInternal(FRIDAY, value);
    }

    /**
     * Gets the attribute value for the calculated attribute Saturday.
     * @return the Saturday
     */
    public Integer getSaturday() {
        return (Integer) getAttributeInternal(SATURDAY);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute Saturday.
     * @param value value to set the  Saturday
     */
    public void setSaturday(Integer value) {
        setAttributeInternal(SATURDAY, value);
    }

    /**
     * getAttrInvokeAccessor: generated method. Do not modify.
     * @param index the index identifying the attribute
     * @param attrDef the attribute

     * @return the attribute value
     * @throws Exception
     */
    protected Object getAttrInvokeAccessor(int index, AttributeDefImpl attrDef) throws Exception {
        if ((index >= AttributesEnum.firstIndex()) && (index < AttributesEnum.count())) {
            return AttributesEnum.staticValues()[index - AttributesEnum.firstIndex()].get(this);
        }
        return super.getAttrInvokeAccessor(index, attrDef);
    }

    /**
     * setAttrInvokeAccessor: generated method. Do not modify.
     * @param index the index identifying the attribute
     * @param value the value to assign to the attribute
     * @param attrDef the attribute

     * @throws Exception
     */
    protected void setAttrInvokeAccessor(int index, Object value, AttributeDefImpl attrDef) throws Exception {
        if ((index >= AttributesEnum.firstIndex()) && (index < AttributesEnum.count())) {
            AttributesEnum.staticValues()[index - AttributesEnum.firstIndex()].put(this, value);
            return;
        }
        super.setAttrInvokeAccessor(index, value, attrDef);
    }
}

