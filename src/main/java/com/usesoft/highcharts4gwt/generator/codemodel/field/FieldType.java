package com.usesoft.highcharts4gwt.generator.codemodel.field;

import javax.annotation.CheckForNull;

public enum FieldType
{
    Number
    {

        @CheckForNull
        @Override
        public <IN, OUT> OUT accept(FieldTypeVisitor<IN, OUT> visitor, IN in)
        {
            return visitor.visitNumber(in);
        }

        @Override
        public boolean isArray()
        {
            return false;
        }

    },
    Boolean
    {

        @CheckForNull
        @Override
        public <IN, OUT> OUT accept(FieldTypeVisitor<IN, OUT> visitor, IN in)
        {
            return visitor.visitBoolean(in);
        }

        @Override
        public boolean isArray()
        {
            return false;
        }

    },
    String
    {

        @CheckForNull
        @Override
        public <IN, OUT> OUT accept(FieldTypeVisitor<IN, OUT> visitor, IN in)
        {
            return visitor.visitString(in);
        }

        @Override
        public boolean isArray()
        {
            return false;
        }

    },
    Object
    {
        @Override
        @CheckForNull
        public <IN, OUT> OUT accept(FieldTypeVisitor<IN, OUT> visitor, IN in)
        {
            return visitor.visitClass(in);
        }

        @Override
        public boolean isArray()
        {
            return false;
        }
    },
    ArrayString
    {

        @CheckForNull
        @Override
        public <IN, OUT> OUT accept(FieldTypeVisitor<IN, OUT> visitor, IN in)
        {
            return visitor.visitArrayString(in);
        }

        @Override
        public boolean isArray()
        {
            return true;
        }

    },
    ArrayNumber
    {
        @Override
        @CheckForNull
        public <IN, OUT> OUT accept(FieldTypeVisitor<IN, OUT> visitor, IN in)
        {
            return visitor.visitArrayNumber(in);
        }

        @Override
        public boolean isArray()
        {
            return true;
        }
    },
    ArrayObject
    {
        @Override
        @CheckForNull
        public <IN, OUT> OUT accept(FieldTypeVisitor<IN, OUT> visitor, IN in)
        {
            return visitor.visitArrayObject(in);
        }

        @Override
        public boolean isArray()
        {
            return true;
        }
    },
    Other
    {
        @Override
        @CheckForNull
        public <IN, OUT> OUT accept(FieldTypeVisitor<IN, OUT> visitor, IN in)
        {
            return visitor.visitOther(in);
        }

        @Override
        public boolean isArray()
        {
            return false;
        }
    },
    Data
    {
        @Override
        @CheckForNull
        public <IN, OUT> OUT accept(FieldTypeVisitor<IN, OUT> visitor, IN in)
        {
            return visitor.visitData(in);
        }

        @Override
        public boolean isArray()
        {
            return true;
        }
    };

    @CheckForNull
    public abstract <IN, OUT> OUT accept(FieldTypeVisitor<IN, OUT> visitor, IN in);

    public abstract boolean isArray();

}
