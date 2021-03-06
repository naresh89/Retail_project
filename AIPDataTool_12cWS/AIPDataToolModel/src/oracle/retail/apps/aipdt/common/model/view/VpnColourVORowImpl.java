package oracle.retail.apps.aipdt.common.model.view;

import java.math.BigDecimal;

import oracle.retail.apps.aipdt.common.adfbc.AipdtViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Mon Feb 01 23:32:38 IST 2016
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class VpnColourVORowImpl extends AipdtViewRowImpl {
    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        DepartmentId {
            public Object get(VpnColourVORowImpl obj) {
                return obj.getAttributeInternal(index());
            }

            public void put(VpnColourVORowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ,
        StyleColorCode {
            public Object get(VpnColourVORowImpl obj) {
                return obj.getAttributeInternal(index());
            }

            public void put(VpnColourVORowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ,
        StyleColorDesc {
            public Object get(VpnColourVORowImpl obj) {
                return obj.getAttributeInternal(index());
            }

            public void put(VpnColourVORowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ,
        ClassId {
            public Object get(VpnColourVORowImpl obj) {
                return obj.getAttributeInternal(index());
            }

            public void put(VpnColourVORowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ,
        SubclassId {
            public Object get(VpnColourVORowImpl obj) {
                return obj.getAttributeInternal(index());
            }

            public void put(VpnColourVORowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ,
        StyleId {
            public Object get(VpnColourVORowImpl obj) {
                return obj.getAttributeInternal(index());
            }

            public void put(VpnColourVORowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ,
        StyleColorId {
            public Object get(VpnColourVORowImpl obj) {
                return obj.getAttributeInternal(index());
            }

            public void put(VpnColourVORowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ;
        private static AttributesEnum[] vals = null;
        private static final int firstIndex = 0;

        public abstract Object get(VpnColourVORowImpl object);

        public abstract void put(VpnColourVORowImpl object, Object value);

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
    public static final int STYLECOLORCODE = AttributesEnum.StyleColorCode.index();
    public static final int STYLECOLORDESC = AttributesEnum.StyleColorDesc.index();
    public static final int CLASSID = AttributesEnum.ClassId.index();
    public static final int SUBCLASSID = AttributesEnum.SubclassId.index();
    public static final int STYLEID = AttributesEnum.StyleId.index();
    public static final int STYLECOLORID = AttributesEnum.StyleColorId.index();

    /**
     * This is the default constructor (do not remove).
     */
    public VpnColourVORowImpl() {
    }
}

