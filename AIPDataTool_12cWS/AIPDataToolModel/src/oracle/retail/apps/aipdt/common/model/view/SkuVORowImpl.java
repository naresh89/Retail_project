package oracle.retail.apps.aipdt.common.model.view;

import java.math.BigDecimal;

import oracle.retail.apps.aipdt.common.adfbc.AipdtViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Mon Feb 01 23:33:52 IST 2016
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class SkuVORowImpl extends AipdtViewRowImpl {
    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        DepartmentId {
            public Object get(SkuVORowImpl obj) {
                return obj.getAttributeInternal(index());
            }

            public void put(SkuVORowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ,
        CommodityCode {
            public Object get(SkuVORowImpl obj) {
                return obj.getAttributeInternal(index());
            }

            public void put(SkuVORowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ,
        CommodityName {
            public Object get(SkuVORowImpl obj) {
                return obj.getAttributeInternal(index());
            }

            public void put(SkuVORowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ,
        ClassId {
            public Object get(SkuVORowImpl obj) {
                return obj.getAttributeInternal(index());
            }

            public void put(SkuVORowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ,
        SubclassId {
            public Object get(SkuVORowImpl obj) {
                return obj.getAttributeInternal(index());
            }

            public void put(SkuVORowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ,
        StyleId {
            public Object get(SkuVORowImpl obj) {
                return obj.getAttributeInternal(index());
            }

            public void put(SkuVORowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ,
        StyleColorId {
            public Object get(SkuVORowImpl obj) {
                return obj.getAttributeInternal(index());
            }

            public void put(SkuVORowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ,
        CommodityId {
            public Object get(SkuVORowImpl obj) {
                return obj.getAttributeInternal(index());
            }

            public void put(SkuVORowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ;
        private static AttributesEnum[] vals = null;
        private static final int firstIndex = 0;

        public abstract Object get(SkuVORowImpl object);

        public abstract void put(SkuVORowImpl object, Object value);

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


    public static final int DEPARTMENTID = AttributesEnum.DepartmentId.index();
    public static final int COMMODITYCODE = AttributesEnum.CommodityCode.index();
    public static final int COMMODITYNAME = AttributesEnum.CommodityName.index();
    public static final int CLASSID = AttributesEnum.ClassId.index();
    public static final int SUBCLASSID = AttributesEnum.SubclassId.index();
    public static final int STYLEID = AttributesEnum.StyleId.index();
    public static final int STYLECOLORID = AttributesEnum.StyleColorId.index();
    public static final int COMMODITYID = AttributesEnum.CommodityId.index();

    /**
     * This is the default constructor (do not remove).
     */
    public SkuVORowImpl() {
    }
}

