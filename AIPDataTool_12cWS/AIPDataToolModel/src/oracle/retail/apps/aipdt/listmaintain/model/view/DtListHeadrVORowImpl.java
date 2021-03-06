package oracle.retail.apps.aipdt.listmaintain.model.view;

import java.math.BigDecimal;

import oracle.jbo.domain.Date;
import oracle.jbo.domain.Number;

import oracle.retail.apps.aipdt.common.adfbc.AipdtViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Fri Feb 26 17:50:00 IST 2016
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class DtListHeadrVORowImpl extends AipdtViewRowImpl {

    public static final int ENTITY_DTLISTHEADREO = 0;
    public static final int ENTITY_DTLOOKUPCODESEO = 1;

    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        CreateDate {
            public Object get(DtListHeadrVORowImpl obj) {
                return obj.getAttributeInternal(index());
            }

            public void put(DtListHeadrVORowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ,
        CreateUser {
            public Object get(DtListHeadrVORowImpl obj) {
                return obj.getAttributeInternal(index());
            }

            public void put(DtListHeadrVORowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ,
        Id {
            public Object get(DtListHeadrVORowImpl obj) {
                return obj.getAttributeInternal(index());
            }

            public void put(DtListHeadrVORowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ,
        IsAutoList {
            public Object get(DtListHeadrVORowImpl obj) {
                return obj.getAttributeInternal(index());
            }

            public void put(DtListHeadrVORowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ,
        IsDeleted {
            public Object get(DtListHeadrVORowImpl obj) {
                return obj.getAttributeInternal(index());
            }

            public void put(DtListHeadrVORowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ,
        Name {
            public Object get(DtListHeadrVORowImpl obj) {
                return obj.getAttributeInternal(index());
            }

            public void put(DtListHeadrVORowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ,
        Privacy {
            public Object get(DtListHeadrVORowImpl obj) {
                return obj.getAttributeInternal(index());
            }

            public void put(DtListHeadrVORowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ,
        SubType {
            public Object get(DtListHeadrVORowImpl obj) {
                return obj.getAttributeInternal(index());
            }

            public void put(DtListHeadrVORowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ,
        Timestamp {
            public Object get(DtListHeadrVORowImpl obj) {
                return obj.getAttributeInternal(index());
            }

            public void put(DtListHeadrVORowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ,
        Type {
            public Object get(DtListHeadrVORowImpl obj) {
                return obj.getAttributeInternal(index());
            }

            public void put(DtListHeadrVORowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ,
        UpdateDate {
            public Object get(DtListHeadrVORowImpl obj) {
                return obj.getAttributeInternal(index());
            }

            public void put(DtListHeadrVORowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ,
        UpdateUser {
            public Object get(DtListHeadrVORowImpl obj) {
                return obj.getAttributeInternal(index());
            }

            public void put(DtListHeadrVORowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ,
        UpdateInd {
            public Object get(DtListHeadrVORowImpl obj) {
                return obj.getAttributeInternal(index());
            }

            public void put(DtListHeadrVORowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ,
        LookupCodeDesc {
            public Object get(DtListHeadrVORowImpl obj) {
                return obj.getAttributeInternal(index());
            }

            public void put(DtListHeadrVORowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ,
        LookupType {
            public Object get(DtListHeadrVORowImpl obj) {
                return obj.getAttributeInternal(index());
            }

            public void put(DtListHeadrVORowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ,
        LookupCode {
            public Object get(DtListHeadrVORowImpl obj) {
                return obj.getAttributeInternal(index());
            }

            public void put(DtListHeadrVORowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ,
        LookupCodeSeq {
            public Object get(DtListHeadrVORowImpl obj) {
                return obj.getAttributeInternal(index());
            }

            public void put(DtListHeadrVORowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ;
        static AttributesEnum[] vals = null;
        ;
        private static final int firstIndex = 0;

        public abstract Object get(DtListHeadrVORowImpl object);

        public abstract void put(DtListHeadrVORowImpl object, Object value);

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


    public static final int CREATEDATE = AttributesEnum.CreateDate.index();
    public static final int CREATEUSER = AttributesEnum.CreateUser.index();
    public static final int ID = AttributesEnum.Id.index();
    public static final int ISAUTOLIST = AttributesEnum.IsAutoList.index();
    public static final int ISDELETED = AttributesEnum.IsDeleted.index();
    public static final int NAME = AttributesEnum.Name.index();
    public static final int PRIVACY = AttributesEnum.Privacy.index();
    public static final int SUBTYPE = AttributesEnum.SubType.index();
    public static final int TIMESTAMP = AttributesEnum.Timestamp.index();
    public static final int TYPE = AttributesEnum.Type.index();
    public static final int UPDATEDATE = AttributesEnum.UpdateDate.index();
    public static final int UPDATEUSER = AttributesEnum.UpdateUser.index();
    public static final int UPDATEIND = AttributesEnum.UpdateInd.index();
    public static final int LOOKUPCODEDESC = AttributesEnum.LookupCodeDesc.index();
    public static final int LOOKUPTYPE = AttributesEnum.LookupType.index();
    public static final int LOOKUPCODE = AttributesEnum.LookupCode.index();
    public static final int LOOKUPCODESEQ = AttributesEnum.LookupCodeSeq.index();

    /**
     * This is the default constructor (do not remove).
     */
    public DtListHeadrVORowImpl() {
    }
}

